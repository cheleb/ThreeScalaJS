import sbt._
import sbt.Keys._
import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._

object Dependencies {
  val Versions = new {
    val frontroute = "0.19.0"
    val mUnit      = "1.0.2"
  }

  val testingLibraryDependencies =
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % Versions.mUnit % Test
    )

  val clientLibraryDependencies: Setting[Seq[ModuleID]] =
    libraryDependencies ++= Seq(
      // "org.scala-js"  %%% "scalajs-dom"        % "2.8.1-local",
      "org.scala-js"  %%% "scalajs-dom"        % "2.8.0",
      "be.doeraene"   %%% "web-components-ui5" % "2.1.0",
      "io.frontroute" %%% "frontroute"         % Versions.frontroute
    )

  val clientAndServerLibraries = Seq(
  )

}
