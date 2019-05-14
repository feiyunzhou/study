package com.company.spark

import org.apache.spark.sql.SparkSession

object DataframeRddApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("dfrdd").master("local[2]").getOrCreate()

    val rdd = spark.sparkContext.textFile("file:///Users/feiyunzhou/infos.txt")

    import spark.implicits._
    val df = rdd.map(_.split(",")).map(line => Info(line(0).toInt, line(1), line(2).toInt)).toDF()
    df.show()

    spark.stop()
  }

  case class Info(id: Int, name: String, age: Int)
}
