package code;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.CassandraRow;

public class SparkToCassandra {

	public SparkToCassandra() {
		// TODO Auto-generated constructor stub	
		SparkConf conf = new SparkConf()
				.setAppName("RocketRoi")
				.setMaster("local");
		SparkContext sc = new SparkContext(conf);
		
		JavaRDD<CassandraRow> cassandraRdd = CassandraJavaUtil.javaFunctions(sc)
		        .cassandraTable("campaign_unido", "campaing1_unido")
		        .select("my_column");
		System.out.println(cassandraRdd.first());
	}

}
