organization := "com.github.y-yu"

name := "guice-with-typeclass"

version := "0.1"

scalaVersion := "2.13.1"

homepage := Some(url("https://github.com/y-yu/guice-with-typeclass"))

licenses := Seq("MIT" -> url(s"https://github.com/y-yu/guice-with-typeclass/blob/master/LICENSE"))

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-Xlint",
  "-language:implicitConversions", "-language:higherKinds", "-language:existentials",
  "-unchecked"
)

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.2.2",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)