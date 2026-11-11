// Build of the giter8 template itself.
// `sbt test` renders the template into target/sbt-test and runs src/test/g8/test against it.
lazy val root = project
  .in(file("."))
  .settings(
    name := "threescalajs.g8",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List("-Xms1024m", "-Xmx1024m", "-Xss2m", "-Dfile.encoding=UTF-8"),
    scriptedBufferLog := false
  )
