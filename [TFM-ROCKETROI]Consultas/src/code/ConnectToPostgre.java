package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.datastax.driver.core.Session;

public class ConnectToPostgre {
	
	Session session;
	Connection conn;
	
	
	public ConnectToPostgre(String ip) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		String User = "postgres";
		String Password = "lasalle18";
		String db = "postgres";
		String Port = "5432";
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://"+ip+":"+Port+"/"+db;
		Properties props = new Properties();
		props.setProperty("user",User);
		props.setProperty("password",Password);
		props.setProperty("ssl","false");
		conn = DriverManager.getConnection(url, props);

		
	}

}
