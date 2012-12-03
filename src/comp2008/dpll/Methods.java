package comp2008.dpll;


public class Methods {

	public static Formula unitPropagation(Formula formula) {

		while (formula.findUnit() != -1) {
		}
		
		return formula;
	}
	
}
