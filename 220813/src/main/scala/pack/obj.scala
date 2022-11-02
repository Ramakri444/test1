package pack

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
object obj {
  case class schema(id:String,tdate:String,name:String)
  def main(args:Array[String]):Unit={
  
    val conf = new SparkConf().setAppName("first").setMaster("local[*]")
			val sc = new SparkContext(conf)
			sc.setLogLevel("ERROR")
			
			val spark = SparkSession.builder().getOrCreate()
      import spark.implicits._
  
  println("===== raw list ======")
			
			val liststr = List(
			    
					"Amazon-Jeff-America",
					"Microsoft-BillGates-America",
					"TCS-TATA-india",
					"Reliance-Ambani-INDIA"
					
					)
					
			liststr.foreach(println)
			
		println
			
		println("===== filter list ======")
		
		val filstr = liststr.filter(x=>x.toLowerCase().contains("india"))
		
		filstr.foreach(println)
		println
		
		println("===== flat data ======")
		
		val flatstr = filstr.flatMap(x=>x.split("-"))
		
		flatstr.foreach(println)
		println
		
		println("===== replace with india ======")
		
		val repstr = flatstr.map(x=>x.replace("india", "local"))
		
		repstr.foreach(println)
		println
		
		println("===== conacat done ======")
		
		val condata = repstr.map(x=>x.concat(",Done"))
		
		condata.foreach(println)

		

}
}
