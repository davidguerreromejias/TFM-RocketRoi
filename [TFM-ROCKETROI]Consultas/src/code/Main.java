package code;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		//ReadFile ReadFile = new ReadFile(args[0]);
		//System.out.print(ReadFile);
		ConnectToCassandra ctc = new ConnectToCassandra(args[0], args[1]);
	}

}
