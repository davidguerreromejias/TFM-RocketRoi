package code;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
	
	Scanner t;
	ArrayList<String[]> Data;
	
	public ReadFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter("\n");
        this.t=scanner;
        //System.out.print(scanner.);
        ArrayList<String[]> Array = new ArrayList<String[]>();
        
        while(scanner.hasNext()){
        	//System.out.print(scanner.nextLine()+"|");
            //System.out.print(scanner.next()+"|");
            String[] rows = scanner.next().split(";");
            Array.add(rows);
        	
        }
        this.Data = Array;
        //System.out.print(Data.get(3)[1]);
        scanner.close();
    }
	
	
	
	public ArrayList<String[]> getData(){
		
		return this.Data;
				
	}
}
