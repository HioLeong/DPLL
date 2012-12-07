package comp2008.dpll;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputHandler {
	
	private static final int CLAUSE_TERMINATOR = 0;

	public InputHandler(String fileName) {
	}

	public static Formula getFormula() {

		Formula formula = null;
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine()
					.substring(5));

			int n = getInteger(tokenizer);
			int m = getInteger(tokenizer);
			formula = new Formula(n, m);
			while (reader.ready()) {

				tokenizer = new StringTokenizer(reader.readLine());
				List<Integer> literals = new ArrayList<Integer>();
				while (tokenizer.hasMoreElements()) {
					int parsedInteger = getInteger(tokenizer);
					if (parsedInteger != CLAUSE_TERMINATOR) {
						literals.add(parsedInteger);
					}
				}
				
				Clause clause = new Clause(literals);
				formula.addClause(clause);
			}
			
		} catch (IOException e) {
			System.out.println("Invalid file name.");
		} catch (Exception e) {
			System.out.println("Invalid cnf definition.");
		}
		
		return formula;
		
	}
	
	private static int getInteger(StringTokenizer tokenizer) {
		return Integer.parseInt(tokenizer.nextToken());
	}

}
