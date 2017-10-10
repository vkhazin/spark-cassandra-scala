scalaVersion := "2.11.11"

name := "SparkCassandra"
organization := "smith.co"
version := "1.0"

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.10" % "2.2.0" % "provided",
  "org.apache.spark" % "spark-sql_2.10" % "2.2.0" % "provided",
  "com.datastax.spark" % "spark-cassandra-connector_2.10" % "2.0.5"
)