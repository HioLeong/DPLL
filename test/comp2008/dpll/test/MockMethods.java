package comp2008.dpll.test;

import java.util.ArrayList;
import java.util.List;

import comp2008.dpll.Clause;

public class MockMethods {
	
	public static Clause makeClause(int[] literals) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : literals) {
			list.add(i);
		}
		return new Clause(list);
	}

}
