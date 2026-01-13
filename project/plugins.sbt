// scalafmt: { maxColumn = 120, style = defaultWithAlign }

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.20.2")

addSbtPlugin("org.scalameta"  % "sbt-scalafmt"        % "2.5.6")
addSbtPlugin("com.github.sbt" % "sbt-pgp"             % "2.3.1")
addSbtPlugin("com.github.sbt" % "sbt-ci-release"      % "1.11.2")
addSbtPlugin("com.eed3si9n"   % "sbt-assembly"        % "2.3.1")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.5")
// Cross project support, to spread project resources between js and jvm world
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.3.2")
addSbtPlugin("com.github.sbt"     % "sbt-dynver"               % "5.1.1")
addSbtPlugin("com.github.sbt"     % "sbt-unidoc"               % "0.6.1")
addSbtPlugin("com.github.sbt"     % "sbt-ghpages"              % "0.9.0")
// will reStart server on code modification.
// Giter8 support
// Scalafix
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.14.5")

addSbtPlugin("dev.cheleb" % "sbt-fullstack-js" % "0.4.0")
