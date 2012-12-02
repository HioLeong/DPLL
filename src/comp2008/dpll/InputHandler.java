package comp2008.dpll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class InputHandler {

	public InputHandler(String fileName) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()
					.substring(5));
			
			int n = getInteger(tokenizer);
			int m = getInteger(tokenizer);
			Formula formula = new Formula(n,m);
			

		} catch (IOException e) {
			System.out.println("Invalid file name.");
		}
	}
	
	public int getInteger(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}

}
