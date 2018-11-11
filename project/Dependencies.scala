import sbt._

object Dependencies {
  val SCALA_VERSION = "2.12.7"

  lazy val jodaTime = "joda-time" % "joda-time" % "2.10.1"

  lazy val playJson = "com.typesafe.play" %% "play-json" % "2.6.10"

  lazy val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2"
}
