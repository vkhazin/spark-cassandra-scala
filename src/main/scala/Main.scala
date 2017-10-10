import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Main extends App {
    println("Connecting to cassandra")
  
		val host = "172.31.36.205"
    val keyspace = "perf8da"
    val table = "digitalasset_3_0_2"
  
		val conf = new SparkConf(true).set("spark.cassandra.connection.host", host)
		val sc = new SparkContext(conf)
	
    val digitalAsset = sc.cassandraTable(keyspace, table).limit(10)

		print("Records received: ")
    println(digitalAsset.cassandraCount())
	
    println("Finished processing")
}

