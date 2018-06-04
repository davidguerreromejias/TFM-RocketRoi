package code;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ReadFile ReadFile = new ReadFile(args[0]);
		System.out.print(ReadFile);
	}

}
