scalaVersion := "2.12.3"

name := "SparkCassandra"
organization := "smith.co"
version := "1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.10" % "2.2.0"
)

