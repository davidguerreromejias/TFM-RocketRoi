package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class ConnectToCassandra {

	Session session;
	
	public ConnectToCassandra(String ip, String keyspace) {
		// TODO Auto-generated constructor stub

		Cluster cluster = Cluster.builder()
		  .addContactPoints(ip)
		  .withCredentials("cassandra", "cassandra")
		  .build();
		
		ProtocolVersion myCurrentVersion = cluster.getConfiguration().getProtocolOptions().getProtocolVersion();
		//System.out.println(myCurrentVersion.getClass().getName());
		session = cluster.connect(keyspace);
	}
	
	public void readToCassandra() {
		String cqlStatement = "select * from accountid_campaign_id";
		for (Row row : session.execute(cqlStatement)) {
			System.out.println(row.toString());
		} 
	}
	
	public void importToCassandra(String cqlStatement) throws FileNotFoundException{
		
		//String cqlStatement = "INSERT INTO accountid_campaign_id (account_id,date_short,ad_group_id,keyword_id,date,campaign_id,avg_cpc,avg_position,bid,clicks,conversion,cost,cpc_max,ctr,first_page_cpc,impressions,keyword_text,keyword_type,quality,status,top_of_page_cpc,all_conversions,conversion_value,search_impression_share,search_rank_lost_impression_share,all_conversion_value,avg_cost,avg_cpe,bounce_rate,click_assisted_conversions,click_assisted_conversions_over_last_click_conversions,click_assisted_conversion_value,cross_device_conversions,first_position_cpc,search_exact_match_impression_share,value_per_all_conversion,value_per_conversion) VALUES (1,'20171209',48321378399,439647333247,'1512777600000',991542199,01,1,NULL,1,0,01,NULL,50,05,2,'tecnolytic','EXACT',10,'ENABLED',0,0,0,100,0,0,01,0,0,0,0,0,0,05,100,0,0);";
		session.execute(cqlStatement);
		//session.close();
	}
	
}
