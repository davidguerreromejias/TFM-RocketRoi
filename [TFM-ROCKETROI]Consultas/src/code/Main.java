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
		
		String[] s =d.getNewDataAd(3, "C:\\Users\\Aleix Che\\TFM\\Prueba 2_0\\Sequencia.csv");
		
		for (int i=0; i<s.length; i++){
			System.out.println(s[i]+";");
			
		}
		
		
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
	   
		
		
		
		
	}

}
