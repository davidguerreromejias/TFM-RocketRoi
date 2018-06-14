package code;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CreateData {
	
	ArrayList<String[]> Data;
	
	public CreateData(String Path) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		
		ReadFile r = new ReadFile(Path);
		this.Data = r.getData();
		//System.out.print(Data.get(3)[1]);
		
	}
	
	public ArrayList<String[]> getNewData(){
		
		ArrayList<String[]> Result = new ArrayList<String[]>(Data);
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
		
		return Result;
	}
	

	public String[] getNewDataAd(int iterations){
		
		//ArrayList<String[]> Result = new ArrayList<String[]>(Data);
	
		long sumi = 10000000000L;
		int datasize = Data.size();
		String[] original = new String [(datasize-1)];
		
		for(int i=1; i<datasize; i++){
			
			//for(int j=0; j < Data.get(i).length; j++){
				original[i-1] = Data.get(i)[1];

				
				
			//}
		}
		String[] newdata = new String [original.length*iterations];
		
		int index =0;
		while(index< newdata.length){
			for(int i=0; i<original.length;i++){
				
				original[i] = Long.toString(Long.parseLong(original[i]) + sumi);
				newdata[index]=original[i];
				index++;
			}
			
		}
		
		return newdata;
	}

}
