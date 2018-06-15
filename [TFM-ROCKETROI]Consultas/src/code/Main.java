package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/*ReadFile ReadFile = new ReadFile(args[0]);
		System.out.print(ReadFile);*/
		
		CreateData d =  new CreateData(args[0]);
		//ArrayList<String[]> a = d.getNewData();
		
		/*for (int i = 1; i< a.size(); i++){
			
			System.out.print(a.get(i)[1]+";");
			
		}*/
		ArrayList<String[]> g = d.getNewData();
		String[] s =d.getNewDataAd(3, "C:\\Users\\Aleix Che\\TFM\\Prueba 2_1\\Sequencia.csv");
		
		/*for (int i=0; i<s.length; i++){
			System.out.println(s[i]+";");
			
		}*/
		
		
		/*ConnectToCassandra ctc = new ConnectToCassandra(args[0], args[1]);
		ctc.importToCassandra();*/
		//SparkToCassandra stc = new SparkToCassandra();
		
		
		
		/*String Path = "C:\\Users\\Aleix Che\\TFM\\Prueba 2_0\\keyword_example.csv";
		ReadFile ReadFile = new ReadFile(Path);
		System.out.print(ReadFile);*/
		
		
		
		//////////////////////////////REALIZAR CONSULTA A POSTGRE//////////////////////////////////////////////
		
		
		/*String Consulta = "SELECT * FROM public.keyword_data as kd left join public.keyword as k on kd.keyword_id = k.id and kd.ad_group_id = k.ad_group_id where kd.ad_group_id = 48151831374;";
	      
	      try {
	         //Class.forName("org.postgresql.Driver");
	         ConnectToPostgre c = new ConnectToPostgre(args[0]);
	         c.readToPostgre(Consulta).forEach(System.out::println);
	        
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");*/
	   
			String table = "public.keyword";
			int dataindex=1;
	      
		      //System.out.println(Consulta);
		      try {
		         //Class.forName("org.postgresql.Driver");
		         ConnectToPostgre c = new ConnectToPostgre(args[1]);
		         for( int i=0; i <s.length; i++){
			    	  
				      String Consulta = "INSERT INTO "+table+"( "+g.get(0)[0]+", "+g.get(0)[1]+", "+g.get(0)[2]+", "+g.get(0)[3]+", "+g.get(0)[4]+", "+g.get(0)[5]+", "+g.get(0)[6]+", "+g.get(0)[7]+", "+g.get(0)[8]+", "+g.get(0)[9]+", "+g.get(0)[10]+", "+g.get(0)[11]+", "+g.get(0)[12]+", "+g.get(0)[13]+", "+g.get(0)[14]+", "+g.get(0)[15]+", "+g.get(0)[16]+", "+g.get(0)[17]+", "+g.get(0)[18]+", "+g.get(0)[19]+", "+g.get(0)[20]+", "+g.get(0)[21]+")VALUES ( "+g.get(dataindex)[0]+", "+s[i]+", "+g.get(dataindex)[2]+", "+g.get(dataindex)[3]+", "+g.get(dataindex)[4]+", '"+g.get(dataindex)[5]+"', '"+g.get(dataindex)[6]+"', '"+g.get(dataindex)[7]+"', '"+g.get(dataindex)[8]+"', '"+g.get(dataindex)[9]+"', '"+g.get(dataindex)[10]+"', '"+g.get(dataindex)[11]+"', '"+g.get(dataindex)[12]+"', '"+g.get(dataindex)[13]+"', '"+g.get(dataindex)[14]+"', '"+g.get(dataindex)[15]+"', "+g.get(dataindex)[16]+", '"+g.get(dataindex)[17]+"', '"+g.get(dataindex)[18]+"', '"+g.get(dataindex)[19]+"', '"+g.get(dataindex)[20]+"', '"+g.get(dataindex)[21]+"');";
				      System.out.println(Consulta);
				      c.writeToPostgre(Consulta);
				      dataindex++;
				      if(dataindex== g.size()){
				    	  dataindex=1;
				      }
				      
		         }
		         //c.readToPostgre(Consulta).forEach(System.out::println);
		        
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }

		      System.out.println("Inserted successfully");
		      
	      
		
	      
	}

}
