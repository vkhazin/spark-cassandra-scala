import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.util.Calendar

object Main extends App {
    println(s"Starting data copy at: ${Calendar.getInstance().getTime()}")
	
		val host = "172.31.36.205"
    val keyspace = "perf8da"
    val srcTable = "digitalasset_3_0_2"
		val trgTable = "digitalassets"
  	val limit = 100
	
		val startTimeMillis = System.currentTimeMillis()
	
		val conf = new SparkConf(true)
										.set("spark.cassandra.connection.host", host)
										.setAppName("TransferImagesSpark2")
	
		val sc = new SparkContext(conf)
		sc.setLogLevel("WARN")
	
    val result = sc.cassandraTable(keyspace, srcTable)
									.limit(limit)
									.saveToCassandra(keyspace, trgTable)	
	
		val finishTimeMillis = System.currentTimeMillis()
	
    println(s"Finished data copy, millisec taken: ${finishTimeMillis - startTimeMillis}, at ${Calendar.getInstance().getTime()}")
}

