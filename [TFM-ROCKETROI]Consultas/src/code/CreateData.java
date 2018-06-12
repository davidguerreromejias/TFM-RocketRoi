package code;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CreateData {
	
	ArrayList<String[]> Data;
	
	public CreateData(String Path) throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		
		ReadFile r = new ReadFile(Path);
		this.Data = r.getData();
	}

}
