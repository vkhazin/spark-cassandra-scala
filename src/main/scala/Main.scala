import com.datastax.spark.connector._
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf

object Main extends App {
    println("Hello, World!")
		val host = "172.31.36.205"
		val conf = new SparkConf(true).set("spark.cassandra.connection.host", host)
		val sc = new SparkContext(conf)    
    val digitalAsset = sc.cassandraTable("perf8da", "digitalasset_3_0_2")
    println(digitalAsset.count)
}

