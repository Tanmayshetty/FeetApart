import play.Project._
import sbt.Keys._

name := "My first application"

version := "1.0"

playJavaSettings

  resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.18"

libraryDependencies += javaEbean



libraryDependencies += "commons-io" % "commons-io" % "2.4"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)