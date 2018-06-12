package code;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ReadFile ReadFile = new ReadFile(args[0]);
		System.out.print(ReadFile);
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
