package code;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class ConnectToCassandra {

	public ConnectToCassandra(String ip, String keyspace) {
		// TODO Auto-generated constructor stub

		Cluster cluster = Cluster.builder()
		  .addContactPoints(ip)
		  .withCredentials("cassandra", "cassandra")
		  .build();

		Session session = cluster.connect(keyspace);
		
		String cqlStatement = "SELECT * FROM campaign2_unido";
		for (Row row : (session.execute(cqlStatement))) {
		  System.out.println(row.toString());
		}
	}
	
	/*public void readToCassandra(Session s) {
		String cqlStatement = "SELECT * FROM campaign_2";
		for (Row row : ((com.datastax.driver.core.Session) s).execute(cqlStatement)) {
		  System.out.println(row.toString());
		}
	}*/

}
