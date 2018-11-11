import Dependencies._

lazy val commonSettings =
  Seq(
    organization := "com.ruchij",
    scalaVersion := SCALA_VERSION
  )

lazy val root =
  (project in file("./"))
    .settings(
      commonSettings,
      name := "asp-rubber-api",
      libraryDependencies ++=
        Seq(jodaTime, playJson)
    )

lazy val userService =
  (project in file("./user-service"))
    .enablePlugins(PlayScala, BuildInfoPlugin)
    .settings(
      commonSettings,
      name := "user-service",
      version := "0.0.1",
      buildInfoKeys := BuildInfoKey.ofN(name, version, scalaVersion, sbtVersion),
      buildInfoPackage := "com.ruchij.eed3si9n",
      libraryDependencies ++=
        Seq(guice) ++ Seq(scalaTestPlusPlay).map(_ % Test)
    )
    .dependsOn(root)