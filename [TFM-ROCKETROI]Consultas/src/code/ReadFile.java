package code;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	
	public ReadFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        scanner.useDelimiter(",");
        /*while(scanner.hasNext()){
            System.out.print(scanner.next()+"|");
        }
        scanner.close();*/
    }
	
	public void importToCassandra (ConnectToCassandra c){
		
		
		
	}

}
