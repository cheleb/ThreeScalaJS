object Dependencies {
  val scalajsDom = "org.scala-js" %%% "scalajs-dom" % "2.8.0"

  def clientLibraryDependencies =
    libraryDependencies ++= Seq(
      scalajsDom
    )
}

inThisBuild(
  List(
    scalaVersion := $scalaVersion$,
    organization := "$organization$",
    homepage     := Some(url("https://github.com/$name$/")),
    publishTo := {
      val centralSnapshots =
        "https://central.sonatype.com/repository/maven-snapshots/"
      if (isSnapshot.value) Some("central-snapshots" at centralSnapshots)
      else localStaging.value
    },
    versionScheme      := Some("early-semver"),
    semanticdbEnabled  := true,
    semanticdbVersion  := scalafixSemanticdb.revision,
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-Wunused:all"
    ),
    pgpPublicRing  := file("/tmp/public.asc"),
    pgpSecretRing  := file("/tmp/secret.asc"),
    pgpPassphrase  := sys.env.get("PGP_PASSWORD").map(_.toArray),
    scmInfo        := Some(
      ScmInfo(
        url("https://github.com/$name$/"),
        "scm:git:git@github.com:$name$.git"
      )
    ),
    developers := List(
      Developer(
        "$organization$",
        "$author$",
        "$email$",
        url("https://github.com/$name$")
      )
    ),
    startYear    := Some(2026),
    licenses += (
      "Apache-2.0",
      url("http://www.apache.org/licenses/LICENSE-2.0")
    ),
    run / fork := true
  )
)

lazy val root = project
  .in(file("."))
  .aggregate(client)
  .settings(
    publish / skip                             := true,
    ScalaUnidoc / unidoc / unidocProjectFilter := inAnyProject -- inProjects(client)
  )

lazy val client = scalajsProject("client")
  .settings(
    scalaJSUseMainModuleInitializer := true,
    scalacOptions ++= Seq(
      "-scalajs",
      "-deprecation",
      "-feature",
      "-Werror"
    )
  )
  .settings(clientLibraryDependencies)
  .settings(
    publish / skip := true
  )

def scalajsProject(projectId: String): Project =
  Project(
    id = s"$projectId",
    base = file(s"modules/$projectId")
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
