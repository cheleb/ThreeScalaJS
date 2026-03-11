import java.nio.charset.StandardCharsets
import org.scalajs.linker.interface.ModuleSplitStyle

import Dependencies._
//
// Will handle different build modes:
// - prod: production mode, aka with BFF and webjar deployment
// - demo: demo mode (default)
// - dev:  development mode
//
import DeploymentSettings._

val scala3 = "3.8.2"

name := "ScalaThree.js"

inThisBuild(
  List(
    scalaVersion       := scala3,
    organization       := "dev.cheleb",
    fullstackJsModules := "example",
    fullstackJsProject := client,
    homepage           := Some(url("https://github.com/cheleb/")),
    publishTo          := {
      val centralSnapshots =
        "https://central.sonatype.com/repository/maven-snapshots/"
      if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
      else localStaging.value
    },
    versionScheme     := Some("early-semver"),
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-Wunused:all"
//      "-Xfatal-warnings"
    ),
    pgpPublicRing := file("/tmp/public.asc"),
    pgpSecretRing := file("/tmp/secret.asc"),
    pgpPassphrase := sys.env.get("PGP_PASSWORD").map(_.toArray),
    scmInfo       := Some(
      ScmInfo(
        url("https://github.com/cheleb/ThreeScalaJS/"),
        "scm:git:git@github.com:cheleb/ThreeScalaJS.git"
      )
    ),
    developers := List(
      Developer(
        "cheleb",
        "Olivier NOUGUIER",
        "olivier.nouguier@gmail.com",
        url("https://github.com/cheleb")
      )
    ),
    startYear := Some(2023),
    licenses += (
      "Apache-2.0",
      url(
        "http://www.apache.org/licenses/LICENSE-2.0"
      )
    ),
    run / fork := true
  )
)

// Aggregate root project
// This is the root project that aggregates all other projects
// It is used to run tasks on all projects at once.
lazy val root = project
  .in(file("."))
  .aggregate(
    client,
    three
  )
  .settings(
    publish / skip                             := true,
    ScalaUnidoc / unidoc / unidocProjectFilter := inAnyProject -- inProjects(client)
  )

val usedScalacOptions = Seq(
  "-encoding",
  "utf8",
  "-unchecked",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Xmax-inlines:64",
  "-Wunused:all"
)

lazy val core = scalajsProject("core")
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0"
    )
  )
  .settings(
    publish / skip := true
  )

lazy val laminar = scalajsProject("laminar")
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0",
      "com.raquo"    %%% "laminar"     % "17.2.0"
    )
  )
  .dependsOn(core)
  .settings(
    publish / skip := true
  )

lazy val three = scalajsProject("threesjs", Some("three"))
  .settings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "2.8.0"
    )
  )

//
// Client project
// It depends on sharedJs project, a project that contains shared code between server and client.
//
lazy val client = scalajsExampleProject("client")
  .enablePlugins(FullstackPlugin)
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { config =>
      mode match {
        case "ESModule" =>
          config
            .withModuleKind(ModuleKind.ESModule)

        case _ =>
          config
            .withModuleKind(ModuleKind.ESModule)
            .withSourceMap(false)
            .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("dev.cheleb.scalajswebgl")))
      }
    }
  )
  .settings(scalacOptions ++= usedScalacOptions)
  .settings(clientLibraryDependencies)
  .dependsOn(core, three, laminar)
  .settings(
    publish / skip := true
  )

def scalajsProject(projectId: String, folder: Option[String] = None): Project =
  Project(
    id = s"$projectId",
    base = file(s"modules/${folder.getOrElse(projectId)}")
  )
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalacOptions := Seq(
        "-scalajs",
        "-deprecation",
        "-feature",
        "-Werror"
      )
    )

def scalajsExampleProject(projectId: String): Project =
  Project(
    id = projectId,
    base = file(s"example/$projectId")
  )
    .enablePlugins(ScalaJSPlugin)
    .settings(
      scalacOptions := Seq(
        "-scalajs",
        "-deprecation",
        "-feature",
        "-Werror"
      )
    )
    .settings(
      publish / skip := true
    )
