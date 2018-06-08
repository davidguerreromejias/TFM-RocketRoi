package code;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//ReadFile ReadFile = new ReadFile(args[0]);
		//System.out.print(ReadFile);
		/*ConnectToCassandra ctc = new ConnectToCassandra(args[0], args[1]);
		ctc.readToCassandra();*/
		//SparkToCassandra stc = new SparkToCassandra();
		
	      
	      try {
	         //Class.forName("org.postgresql.Driver");
	         ConnectToPostgre c = new ConnectToPostgre("192.168.1.36");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	   
		
		
		
		
	}

}
