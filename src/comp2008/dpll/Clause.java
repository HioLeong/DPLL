package comp2008.dpll;

import java.util.List;

public class Clause {

	private List<Integer> literals;

	public Clause(List<Integer> clauses) {
		this.literals = clauses;
	}

	public boolean contains(int n) {
		return literals.contains(n);
	}

	public boolean removeLiteral(int n) {
		if (contains(n)) {
			literals.remove(n);
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
	
	/**
	 * Method for retrieving the first literal, used when clause contains only one literal.
	 * 
	 * @return
	 */
	public int getFirstLiteral() {
		return literals.get(0);
	}

}
