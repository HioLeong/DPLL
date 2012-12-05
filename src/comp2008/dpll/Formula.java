package comp2008.dpll;

import java.util.ArrayList;
import java.util.List;

/**
 * Formula class with
 * 
 * @author Hio
 * 
 */

public class Formula {
	
	public final static int NO_SINGLE_UNIT = -1;

	private int n; // number of distinct literals
	private int m; // number of clauses
	private List<Clause> clauses = new ArrayList<Clause>();

	public Formula() {
		m = 0;
		n = 0;
	}

	public Formula(int n, int m) {
		this.n = n;
		this.m = m;
	}

	public Formula(Formula original) {
		for (Clause c : original.getClauses()) {
			List<Integer> literals = new ArrayList<Integer>();
			for (int literal : c.getLiterals()) {
				literals.add(literal);
			}
			Clause cloneClause = new Clause(literals);
			clauses.add(cloneClause);
		}
	}

	public void addClause(Clause clause) {
		clauses.add(clause);
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
		return NO_SINGLE_UNIT;
	}

	public void simplifyUnit(int literal) {
		for (int i = 0; i < clauses.size(); i++) {
			if (clauses.get(i).contains(literal)) {
				clauses.remove(i);
				return;
			}
			if (clauses.get(i).contains(-literal)) {
				clauses.get(i).removeLiteral(-literal);
				return;
			}
		}
	}

	public List<Clause> getClauses() {
		return clauses;
	}

	public boolean hasEmptyClause() {
		for (Clause c : clauses) {
			if (c.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the first literal from the clauses.
	 * 
	 * @return
	 */
	public int pickLiteral() {
		return clauses.get(0).getFirstLiteral();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clauses == null) ? 0 : clauses.hashCode());
		result = prime * result + m;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formula other = (Formula) obj;
		if (clauses == null) {
			if (other.clauses != null)
				return false;
		} else if (!clauses.equals(other.clauses))
			return false;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
		return true;
	}

}
