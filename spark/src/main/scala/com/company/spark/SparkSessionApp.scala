package com.company.spark

import org.apache.spark.sql.SparkSession

object SparkSessionApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("spark sql example")
      .config("spark.some.config.option", "somevalue").master("local[2]").getOrCreate()

    val person = spark.read.format("json").load("file:///Users/feiyunzhou/person.json")
    person.show()



    person.printSchema()

    person.select("name").show()




    spark.close()
  }
}
