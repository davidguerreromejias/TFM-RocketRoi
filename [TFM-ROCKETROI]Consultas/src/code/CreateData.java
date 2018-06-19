package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateData {
	
	ArrayList<String[]> Data;
	
	public CreateData(String Path) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		
		ReadFile r = new ReadFile(Path);
		this.Data = r.getData();
		//System.out.print(Data.get(3)[1]);
		
	}
	
	public ArrayList<String[]> getNewData(){
		
		/*ArrayList<String[]> Result = new ArrayList<String[]>(Data);
		long multiplie = 10000000000L;
		//Result.set(0,Data.get(0));
		//Result = Data;
		String[] s =null;
		for(int i=1; i<Result.size(); i++){
			
			//for(int j=0; j < Data.get(i).length; j++){
				s = Result.get(i);
				//long k = Long.parseLong(s[2].toString())+ multiplier;
				s[1] = Long.toString(Long.parseLong(s[1]) + multiplie);
				
				//Result.set(i, s);
				
				//System.out.print(Long.parseLong(Data.get(i)[1].toString()));
				//Result.get(i)[1] = Long.toString(k) ;
				//Result.set(i, Long.toString(k));
				
				
			//}
		}
		
		return Result;*/
		return Data;
	}
	

	public String[] getNewDataAd(int iterations, String Path) throws IOException{
		
		//ArrayList<String[]> Result = new ArrayList<String[]>(Data);
		Scanner scanner = new Scanner(new File(Path));
        scanner.useDelimiter("\n");
        ArrayList<String> Array = new ArrayList<String>();
        
        while(scanner.hasNext()){
        	//System.out.print(scanner.nextLine()+"|");
            //System.out.print(scanner.next()+"|");
        	Array.add(scanner.next().replace("\n", "").replace("\r", ""));
        	
        }
        
        String [] original= new String[Array.size()-1];
        
        for (int i = 0; i< original.length; i++){
        	
        	original[i]= Array.get(i+1);
        	
        }
        //System.out.println(original);
		long sumi = 10000000000L;
		/*int datasize = Data.size();
		String[] original = new String [(datasize-1)];*/
		
		/*for(int i=1; i<datasize; i++){
			
			//for(int j=0; j < Data.get(i).length; j++){
				original[i-1] = Data.get(i)[1];

				
				
			//}
		}*/
		String[] newdata = new String [original.length*iterations];
		
		int index =0;
		int index2=0;
		String[] Savearray = new String[original.length];
		while(index< newdata.length){
			for(int i=0; i<original.length;i++){
				
				original[i] = Long.toString(Long.parseLong(original[i]) + sumi);
				newdata[index]=original[i];
				if(index>=original.length*(iterations-1) || iterations == 1 ){
					
					Savearray[index2] = original[i];
					index2++;
					
				}
				index++;
			}
			
		}
		
		WriteCSV(Savearray, "/Users/laperlablancaIV/Documents/javaCassandra/Sequencia2.csv");
		return newdata;
		
	}
	
	public void WriteCSV(String[] array, String Path) throws IOException{
		
		FileWriter fileWriter = null;
		fileWriter = new FileWriter(Path);
		String NEW_LINE_SEPARATOR = "\n";
		
		fileWriter.append(String.valueOf("ad_group_id"));
		fileWriter.append(NEW_LINE_SEPARATOR);
		
		for (int i=0; i<array.length; i++) {
			
			fileWriter.append(String.valueOf(array[i]));
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			
		}
		
		fileWriter.close();

	}

}
