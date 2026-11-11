import org.scalajs.linker.interface.ModuleSplitStyle

ThisBuild / scalaVersion := "$scala_version$"
ThisBuild / organization := "$organization$"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "$name;format="norm"$",
    scalacOptions ++= Seq("-deprecation", "-feature", "-Wunused:all"),
    // The application has a `main` method: run it when the module is loaded.
    scalaJSUseMainModuleInitializer := true,
    // Vite consumes ES modules; small modules for our package give fast incremental reloads.
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("$package$")))
    },
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "$scalajs_dom_version$",
      "dev.cheleb"   %%% "threesjs"    % "$threesjs_version$"
    )
  )
