package code;

import com.datastax.driver.core.Cluster;
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

		session = cluster.connect(keyspace);
	}
	
	public void readToCassandra() {
		String cqlStatement = "select * from campaign2_unido where ad_group_id = 48151831374";
		for (Row row : session.execute(cqlStatement)) {
			System.out.println(row.toString());
		} 
	}
	
}
