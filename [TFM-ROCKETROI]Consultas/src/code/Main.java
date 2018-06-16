package code;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;

public class Main {

	public static void main(String[] args) throws IOException {
		
		
		String allColumnsPath = args[0]+"\\campana2_1.csv";
		String AdGroupPath = args[0]+"\\Sequencia.csv";
		System.out.println(allColumnsPath);
		
		CreateData d =  new CreateData(allColumnsPath);
		
		ArrayList<String[]> g = d.getNewData();
		System.out.println(g.size());
		String[] s =d.getNewDataAd(5, AdGroupPath);
		
		
		ConnectToCassandra ctc = new ConnectToCassandra(args[2], "campaign");
		String table = "AccountID_campaign_ID";
		int dataindex=1;
		
		Date startDate = new Date();
        for( int i=0; i <s.length; i++){
	    	  
		      String Consulta = "INSERT INTO "+table+"( "+g.get(0)[0]+", "+g.get(0)[1]+", "+g.get(0)[2]+", "+g.get(0)[3]+", "+g.get(0)[4]+", "+g.get(0)[5]+", "+g.get(0)[6]+", "+g.get(0)[7]+", "+g.get(0)[8]+", "+g.get(0)[9]+", "+g.get(0)[10]+", "+g.get(0)[11]+", "+g.get(0)[12]+", "+g.get(0)[13]+", "+g.get(0)[14]+", "+g.get(0)[15]+", "+g.get(0)[16]+", "+g.get(0)[17]+", "+g.get(0)[18]+", "+g.get(0)[19]+", "+g.get(0)[20]+", "+g.get(0)[21]+", "+g.get(0)[22]+", "+g.get(0)[23]+", "+g.get(0)[24]+", "+g.get(0)[25]+", "+g.get(0)[26]+", "+g.get(0)[27]+", "+g.get(0)[28]+", "+g.get(0)[29]+", "+g.get(0)[30]+", "+g.get(0)[31]+", "+g.get(0)[32]+", "+g.get(0)[33]+", "+g.get(0)[34]+", "+g.get(0)[35]+", "+g.get(0)[36]+")VALUES ( "+g.get(dataindex)[0]+", '"+g.get(dataindex)[1]+"', "+s[i]+", "+g.get(dataindex)[3]+", '"+g.get(dataindex)[4]+"', "+g.get(dataindex)[5]+", "+g.get(dataindex)[6]+", "+g.get(dataindex)[7]+", "+g.get(dataindex)[8]+", "+g.get(dataindex)[9]+", "+g.get(dataindex)[10]+", "+g.get(dataindex)[11]+", "+g.get(dataindex)[12]+", "+g.get(dataindex)[13]+", "+g.get(dataindex)[14]+", "+g.get(dataindex)[15]+", '"+g.get(dataindex)[16]+"', '"+g.get(dataindex)[17]+"', "+g.get(dataindex)[18]+", '"+g.get(dataindex)[19]+"', "+g.get(dataindex)[20]+", "+g.get(dataindex)[21]+", "+g.get(dataindex)[22]+", "+g.get(dataindex)[23]+", "+g.get(dataindex)[24]+", "+g.get(dataindex)[25]+", "+g.get(dataindex)[26]+", "+g.get(dataindex)[27]+", "+g.get(dataindex)[28]+", "+g.get(dataindex)[29]+", "+g.get(dataindex)[30]+", "+g.get(dataindex)[31]+", "+g.get(dataindex)[32]+", "+g.get(dataindex)[33]+", "+g.get(dataindex)[34]+", "+g.get(dataindex)[35]+", "+g.get(dataindex)[36]+");";
		      //System.out.println(Consulta);
		      ctc.importToCassandra(Consulta);
		      dataindex++;
		      if(dataindex== g.size()){
		    	  dataindex=1;
		      }
		      
        }
        Date endDate = new Date();
        
        int msElapsedTime = (int) (endDate.getTime() - startDate.getTime());
        ctc.session.close();
        System.out.println("Inserted Succesfully in "+ msElapsedTime+" ms");
		
		
		/*ConnectToCassandra ctc = new ConnectToCassandra(args[0], args[1]);
		ctc.importToCassandra();*/
		//SparkToCassandra stc = new SparkToCassandra();
		

		
		//////////////////////////////REALIZAR CONSULTA DE LECTURA A POSTGRE//////////////////////////////////////////////
		
		
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
	   
		
		
		
//////////////////////////////REALIZAR CONSULTA DE ESCRITURA A POSTGRE//////////////////////////////////////////////
			/*String table = "public.keyword";
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

		      System.out.println("Inserted successfully");*/
		      
	      
		
	      
	}

}
