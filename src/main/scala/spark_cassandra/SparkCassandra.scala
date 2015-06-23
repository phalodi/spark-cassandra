package spark_cassandra

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import com.datastax.spark.connector._

object SparkCassandra extends App {
  val conf = new SparkConf(true)
    .set("spark.cassandra.connection.host", "127.0.0.1").setAppName("cassandra").setMaster("local[*]")
    .set("spark.cassandra.connection.native.port", "9042")
    .set("spark.cassandra.connection.rpc.port", "9160")
  val sc = new SparkContext(conf)
  val rdd = sc.cassandraTable("spark", "try")
  val file_collect=rdd.collect()
  file_collect.map(println(_))
}