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

}
