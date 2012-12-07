package comp2008.dpll;

public class Main {
	
	public static void main(String[] args) {
		
		Formula formula = InputHandler.getFormula();
		if (Methods.DPLL(formula)) {
			System.out.println("Satisfiable");
		} else {
			System.out.println("Unsatisfiable");
		}
		
	}
	
}
