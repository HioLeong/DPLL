package comp2008.dpll;

import java.util.List;

public class Formula {

	private int n; // number of distinct literals
	private int m; // number of clauses
	private List<Clause> clauses;

	public Formula() { 
		m = 0;
		n = 0;
	}

	public Formula(int n, int m) {
		this.n = n;
		this.m = m;
	}

	/**
	 * Method finding a clause which contains one literal, if found, the literal
	 * is returned, otherwise -1 is returned.
	 * 
	 * @return the unit, or -1 if not found.
	 */
	public int findUnit() {
		for (Clause c : clauses) {
			if (c.size() == 1) {
				return c.getFirstLiteral();
			}
		}
		return -1;
	}

}
