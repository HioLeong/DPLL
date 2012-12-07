package comp2008.dpll;

import java.util.ArrayList;
import java.util.List;

/**
 * High abstracted methods which are applied to the formulas.
 * 
 * @author Hio
 * 
 */

public class Methods {

	public static Formula unitPropagation(Formula formula) {

		while (formula.findUnit() != Formula.NO_SINGLE_UNIT) {
			formula.simplifyUnit(formula.findUnit());
		}
		
		return formula;
	}

	public static boolean DPLL(Formula formula) {
		if (unitPropagation(formula).hasEmptyClause()) {
			return false;
		}
		return splitting(formula);
	}

	public static boolean splitting(Formula formula) {

		int pickedLiteral = formula.pickLiteral();

		if (subSplit(formula, pickedLiteral)) {
			return true;
		}
		if (subSplit(formula, -pickedLiteral)) {
			return true;
		}
		return false;

	}

	private static boolean subSplit(Formula formula, int literal) {
		
		Formula split = new Formula(formula);
		List<Integer> pickedLiteralList = new ArrayList<Integer>();
		pickedLiteralList.add(literal);
		
		
		Clause clause = new Clause(pickedLiteralList);
		split.addClause(clause);
		if (!unitPropagation(split).hasEmptyClause()) {
			return true;
		}
		
		return false;
	}
}
