package co.smith

import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.util.Calendar

object CopyData extends App {

	println(s"Starting data copy at: ${Calendar.getInstance().getTime()}")

	val fileName = if (args.length > 0) args(0) else "/etc/co.smith.CopyData/application.conf"
	if (!(new java.io.File(fileName).exists)) throw new IllegalArgumentException(s"Configuration file: '$fileName' was not found");

	val appConfig =  com.typesafe.config.ConfigFactory.parseFile(new java.io.File(fileName))
	val cassandraHost = appConfig.getString("cassandraHost")
	val sourceKeyspace = appConfig.getString("sourceKeyspace")
	val sourceTable = appConfig.getString("sourceTable")
	val targetKeyspace = appConfig.getString("targetKeyspace")
	val targetTable = appConfig.getString("targetTable")
	val limit = appConfig.getInt("limit")

	val startTimeMillis = System.currentTimeMillis()

	val sparkConf = new SparkConf(true)
									.set("spark.cassandra.connection.host", cassandraHost)
									.setAppName("TransferImagesSpark2")

	val sc = new SparkContext(sparkConf)
	sc.setLogLevel("WARN")

	val result = sc.cassandraTable(sourceKeyspace, sourceTable)
								.limit(limit)
								.saveToCassandra(targetKeyspace, targetTable)	

	val finishTimeMillis = System.currentTimeMillis()

	println(s"Finished data copy, millisec taken: ${finishTimeMillis - startTimeMillis}, at ${Calendar.getInstance().getTime()}")
}

