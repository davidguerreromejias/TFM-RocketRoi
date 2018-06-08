package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class ConnectToPostgre {
	

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
	
	public String readToPostgre(String consulta) throws SQLException {
		
        String Result = null;
 
        try (   Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(consulta)) {
            rs.next();
            Result = rs.getString(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Result;
		
		
	}

}
