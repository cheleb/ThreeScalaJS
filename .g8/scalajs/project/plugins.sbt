// scalafmt: { maxColumn = 120, style = defaultWithAlign }

addSbtPlugin("org.scala-js" % "sbt-scalajs" % "$scalajsVersion$")

addSbtPlugin("org.scalameta"  % "sbt-scalafmt"       % "2.6.2")
addSbtPlugin("com.github.sbt" % "sbt-pgp"             % "2.3.2")
addSbtPlugin("com.github.sbt" % "sbt-ci-release"      % "1.12.1")
addSbtPlugin("com.eed3si9n"   % "sbt-assembly"        % "2.5.0")
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.7")
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.4.0")
addSbtPlugin("com.github.sbt"     % "sbt-dynver"               % "5.1.1")
addSbtPlugin("com.github.sbt"     % "sbt-unidoc"               % "0.6.1")
addSbtPlugin("com.github.sbt"     % "sbt-ghpages"              % "0.10.0")
addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.14.8")
addSbtPlugin("ch.epfl.scala" % "sbt-bloop" % "2.1.1")
