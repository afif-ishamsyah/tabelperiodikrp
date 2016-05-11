name := "play-java"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "org.apache.jena" % "jena-core" % "3.0.1",
  "org.apache.jena" % "jena-arq" % "3.0.1"
)
