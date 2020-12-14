import org.apache.spark.sql.SparkSession

object FutureXSparkTransformer {

  def main(args: Array[String]): Unit = {

    System.setProperty("hadoop.home.dir", "C:\\hadoop")

    val spark = SparkSession
      .builder()
      .appName("SparkScalaProject")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()

    val coursesSeq = Seq((1, "spark"), (2, "Big Data"))

    val df = spark.createDataFrame(coursesSeq).toDF("id", "name")
    df.show
    df.write.format("csv").save("courses")
  }
}
