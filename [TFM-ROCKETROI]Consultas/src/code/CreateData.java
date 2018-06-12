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
		
		ArrayList<String[]> Result = Data;
		long multiplier =10000000000L;
		for(int i=1; i<Data.size(); i++){
			
			//for(int j=0; j < Data.get(i).length; j++){
				
				
				long k = Long.parseLong(Data.get(i)[1].toString())+ multiplier;
				//System.out.print(Long.parseLong(Data.get(i)[1].toString()));
				Result.get(i)[1] = Long.toString(k) ;
				//Result.set(i, Long.toString(k));
				
				
			//}
		}
		
		return Result;
	}

}
