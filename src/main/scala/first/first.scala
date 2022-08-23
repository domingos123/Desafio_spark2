package first

import org.apache.spark
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructType}
import org.apache.spark.{SparkConf, SparkContext}

object first {

    def main(args: Array[String]): Unit = {

        val conf = new SparkConf().
          setMaster("C:/Users/domin/ideaProjects/untitled").
          setAppName("Read-csv")
        val sc = new SparkContext(conf)
        val spark_session = SparkSession.builder().config(conf).getOrCreate()
        sc.setLogLevel("Error")

        val arrayStructureSchema_user = new StructType()
          .add("column name", new StructType()
            .add("Data type", StringType)
            .add("default value", StringType)
            .add("notes", StringType))

        val arrayStructureSchema = new StructType()
          .add("column name",new StructType()
            .add("Data type",StringType)
            .add("default value",StringType)
            .add("IMPORTANT notes",StringType))


       // val df = spark.createDataFrame(
           // spark.SparkContext.parallelize(arrayStructureData),arrayStructureSchema)
        //df.printSchema()
       // df.show()

        val df_3 = sc.textFile("C:/Users/domin/ideaProjects/untitled/src/main/data/googleplaystore.csv")
        val df_1 = sc.textFile("C:/Users/domin/ideaProjects/untitled/src/main/data/googleplaystore_user_reviews.csv")

        val items_rating = df_3.map(ol => ol.split(",")(2)).filter(ox => ox != "3" != "2" != "1" != "0" )
        //items_rating.write.csv("")
        //items_rating.sortBy(k => -k)
        println(items)
    }
}
