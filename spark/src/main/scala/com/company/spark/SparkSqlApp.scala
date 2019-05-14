package com.company.spark

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

object SparkSqlApp {

  def main(args: Array[String]): Unit = {
    val sparconf = new SparkConf()
    sparconf.setAppName("asparkname").setMaster("local[2]")
    val sc= new SparkContext(sparconf)
    val sQLContext = new SQLContext(sc)

    val person = sQLContext.read.format("json").load("/Users/feiyunzhou/person.json")
    person.printSchema()
    person.show()
    //process json
    //sQLContext.createdata
    sc.stop()
  }

}
