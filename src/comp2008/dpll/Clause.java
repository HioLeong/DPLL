package comp2008.dpll;

import java.util.ArrayList;
import java.util.List;

public class Clause {

	private List<Integer> literals;

	public Clause() {
		literals = new ArrayList<Integer>();
	}
	
	public Clause(List<Integer> clauses) {
		this.literals = clauses;
	}

	public boolean contains(int n) {
		return literals.contains(n);
	}

	public boolean removeLiteral(int n) {
		if (contains(n)) {
			literals.remove(literals.indexOf(n));
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (literals.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public int size() {
		return literals.size();
	}
	
	public void removeAllLiterals() {
		literals.clear();
	}

	/**
	 * Method for retrieving the first literal, used when clause contains only
	 * one literal.
	 * 
	 * @return
	 */
	public int getFirstLiteral() {
		return literals.get(0);
	}

	public List<Integer> getLiterals() {
		return literals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((literals == null) ? 0 : literals.hashCode());
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
		Clause other = (Clause) obj;
		if (literals == null) {
			if (other.literals != null)
				return false;
		} else if (!literals.equals(other.literals))
			return false;
		return true;
	}

}
