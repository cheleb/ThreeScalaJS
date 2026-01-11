import com.typesafe.sbt.packager.archetypes.JavaAppPackaging
import com.typesafe.sbt.packager.archetypes.scripts.AshScriptPlugin
import com.typesafe.sbt.packager.docker.DockerPlugin
import com.typesafe.sbt.SbtNativePackager.autoImport._

import java.nio.charset.StandardCharsets
import java.nio.file.Files

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import org.scalajs.sbtplugin._

import sbt._
import sbt.Keys._

object DeploymentSettings {
//
// Define the build mode:
// - CommonJs: production mode, aka with BFF and webjar deployment
//         optimized, CommonJSModule
//         webjar packaging
// - ESModule: demo mode (default)
//         optimized, CommonJSModule
//         static files
// - dev:  development mode
//         no optimization, ESModule
//         static files, hot reload with vite.
//
// Default is "demo" mode, because the vite build does not take parameters.
//   (see vite.config.js)
  val mode = sys.env.get("MOD").getOrElse("demo")

  val overrideDockerRegistry = sys.env.get("LOCAL_DOCKER_REGISTRY").isDefined

  val publicFolder = "public"

//
// On dev mode, server will only serve API and static files.
//
  val serverPlugins = mode match {
    case "ESModule" =>
      Seq(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
    case _ => Seq()
  }

  def serverSettings(clientProjects: Project*) = mode match {
    case "ESModule" => dockerSettings
    case _          => Seq()
  }

  def staticGenerationSettings(generator: Project, client: Project) = mode match {
    case "ESModule" =>
      Seq(
        (Compile / resourceGenerators) += Def
          .taskDyn[Seq[File]] {
            val rootFolder = (Compile / resourceManaged).value / publicFolder
            rootFolder.mkdirs()

            Def.task {
              if (
                scala.sys.process
                  .Process(
                    List("npm", "run", "build", "--", "--emptyOutDir", "--outDir", rootFolder.getAbsolutePath),
                    (client / baseDirectory).value
                  )
                  .! == 0
              ) {
                println(s"Generated static files in ${rootFolder}")
                (rootFolder ** "*.*").get
              } else {
                println(s"Failed to generate static files in ${rootFolder}")
                throw new IllegalStateException("Vite build failed")
              }

            }

          }
          .taskValue
      )
    case _ =>
      Seq()
  }

  def symlink(link: File, target: File): Unit = {
    if (!(Files.exists(link.getParentFile.toPath)))
      Files.createDirectories(link.getParentFile.toPath)
    if (!(Files.exists(link.toPath) || Files.isSymbolicLink(link.toPath)))
      if (Files.exists(target.toPath))
        Files.createSymbolicLink(link.toPath, link.toPath.getParent.relativize(target.toPath))
  }

  lazy val dockerSettings = {
    import DockerPlugin.autoImport._
    import DockerPlugin.globalSettings._
    import sbt.Keys._
    Seq(
      Docker / maintainer     := "Joh doe",
      Docker / dockerUsername := Some("johndoe"),
      Docker / packageName    := "scalajs-webgl",
      dockerBaseImage         := "azul/zulu-openjdk-alpine:23-latest",
      dockerRepository        := Some("registry.orb.local"),
      dockerUpdateLatest      := true,
      dockerExposedPorts      := Seq(8000)
    ) ++ (overrideDockerRegistry match {
      case true =>
        Seq(
          Docker / dockerRepository := Some("registry.orb.local"),
          Docker / dockerUsername   := Some("zio-laminar-demo")
        )
      case false =>
        Seq()
    })
  }

}
