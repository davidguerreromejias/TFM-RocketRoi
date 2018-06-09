package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;



public class ConnectToPostgre {
	

	Connection conn;
	Statement stm;
	
	
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
	
	public ArrayList<String> readToPostgre(String consulta) throws SQLException{
		     
		stm = conn.createStatement();
		
		Date startDate = new Date();
		ResultSet rs = stm.executeQuery(consulta);
		Date endDate = new Date();
		
		ResultSetMetaData rsm = rs.getMetaData(); 
		ArrayList<String> Array = new ArrayList<String>();
		String row;
		
		while (rs.next()){
			
			row = null;
			
			for ( int i=1; i < (rsm.getColumnCount()+1);i++) {
				
				row = row + " , " + rs.getString(i);
				
			}
			
			Array.add(row);
		}
		
		int msElapsedTime = (int) (endDate.getTime() - startDate.getTime());
		Array.add(Integer.toString(msElapsedTime));
		
		stm.close();
		rs.close();
		conn.close();
		return Array;

     
        
		
		
	}

}
