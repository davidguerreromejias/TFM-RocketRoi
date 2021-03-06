package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		String Password = "postgres";
		String db = "postgres";
		String Port = "5432";
		Class.forName("org.postgresql.Driver");
		
		String url = "jdbc:postgresql://"+ip+":"+Port+"/"+db;
		Properties props = new Properties();
		props.setProperty("user",User);
		props.setProperty("password",Password);
		props.setProperty("ssl","false");
		conn = DriverManager.getConnection(url, props);
		stm = conn.createStatement();
		
	}
	
	public ArrayList<String> readToPostgre(String consulta) throws SQLException{
		     
		
		
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
		//conn.close();
		return Array;

     
        
		
		
	}
	

public void writeToPostgre(String consulta) throws SQLException{
		     
		
		
		Date startDate = new Date();
		PreparedStatement st = conn.prepareStatement(consulta);
		st.executeUpdate();
		st.close();
		//stm.executeQuery(consulta);
		Date endDate = new Date();
		

		int msElapsedTime = (int) (endDate.getTime() - startDate.getTime());
	  
		
		
	}

}
