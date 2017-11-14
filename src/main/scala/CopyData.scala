package co.smith

import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.util.Calendar

object CopyData extends App {

	def addColumns(row: CassandraRow): CassandraRow = {
		val inputMap = row.toMap
		val newColumns = Map(
			"field1" -> inputMap("name")
		)
		var outputMap = inputMap ++ newColumns
		CassandraRow.fromMap(outputMap)
	}
	
	println(s"Starting data copy at: ${Calendar.getInstance().getTime()}")

	val fileName = if (args.length > 0) args(0) else "/etc/co.smith.CopyData/application.conf"
	if (!(new java.io.File(fileName).exists)) throw new IllegalArgumentException(s"Configuration file: '$fileName' was not found");

	val appConfig =  com.typesafe.config.ConfigFactory.parseFile(new java.io.File(fileName))
	
	val sparkMasterUrl = appConfig.getString("sparkMasterUrl")
	val cassandraDC = appConfig.getString("cassandraDC")
	val cassandraHost = appConfig.getString("cassandraHost")
	val sourceKeyspace = appConfig.getString("sourceKeyspace")
	val sourceTable = appConfig.getString("sourceTable")
	val targetKeyspace = appConfig.getString("targetKeyspace")
	val targetTable = appConfig.getString("targetTable")
	val limit: Int = if (appConfig.getInt("limit") > 0) appConfig.getInt("limit") else 1000000000

	val startTimeMillis = System.currentTimeMillis()

	val sparkConf = new SparkConf(true)
	sparkConf.set("spark.cassandra.connection.host", cassandraHost)
	sparkConf.setAppName("CopyData")
	
	if (!sparkMasterUrl.isEmpty) {
		sparkConf.setMaster(sparkMasterUrl)
	}
	
	if (!cassandraDC.isEmpty) {
		sparkConf.set("spark.cassandra.connection.local_dc", cassandraDC)
	}

	val sc = new SparkContext(sparkConf)
	sc.setLogLevel("WARN")
	
	val result = sc.cassandraTable(sourceKeyspace, sourceTable)
								.limit(limit)
								.map(addColumns(_))
								.saveToCassandra(targetKeyspace, targetTable)	

	val finishTimeMillis = System.currentTimeMillis()

	println(s"Finished data copy, millisec taken: ${finishTimeMillis - startTimeMillis}, at ${Calendar.getInstance().getTime()}")
}

