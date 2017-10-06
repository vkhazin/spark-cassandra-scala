scalaVersion := "2.11.7"

name := "SparkCassandra"
organization := "smith.co"
version := "1.0"

libraryDependencies ++= Seq(
//   "org.apache.spark" % "spark-core_2.10" % "2.2.0",
//   "com.datastax.spark" % "spark-cassandra-connector_2.10" % "2.0.5"
)

// assemblyMergeStrategy in assembly := {
//   case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
//   case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
//   case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
//   case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
//   case PathList("org", "apache", xs @ _*) => MergeStrategy.last
//   case PathList("com", "google", xs @ _*) => MergeStrategy.last
//   case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
//   case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
//   case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
//   case "about.html" => MergeStrategy.rename
//   case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
//   case "META-INF/mailcap" => MergeStrategy.last
//   case "META-INF/mimetypes.default" => MergeStrategy.last
//   case "plugin.properties" => MergeStrategy.last
//   case "log4j.properties" => MergeStrategy.last
//   case x =>
//     val oldStrategy = (assemblyMergeStrategy in assembly).value
//     oldStrategy(x)
// }