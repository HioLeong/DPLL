package comp2008.dpll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputHandler {
	
	private Formula formula;

	public InputHandler(String fileName) {
		try {
			FileReader file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()
					.substring(5));

			int n = getInteger(tokenizer);
			int m = getInteger(tokenizer);
			formula = new Formula(n, m);
			while (reader.ready()) {

				tokenizer = new StringTokenizer(reader.readLine());
				List<Integer> literals = new ArrayList<Integer>();
				while (tokenizer.hasMoreElements()) {
					literals.add(getInteger(tokenizer));
				}
				
				Clause clause = new Clause(literals);
				formula.addClause(clause);
			}
			
		} catch (IOException e) {
			System.out.println("Invalid file name.");
		} catch (Exception e) {
			System.out.println("Invalid cnf definition.");
		}
	}

	public Formula getFormula() {
		// TODO: Change into static method.
		return formula;
	}
	
	public int getInteger(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}

}
