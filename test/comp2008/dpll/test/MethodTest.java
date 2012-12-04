package comp2008.dpll.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import comp2008.dpll.Clause;
import comp2008.dpll.Formula;
import comp2008.dpll.Methods;

public class MethodTest {

	@Test
	public void testUnitPropagation() {
		
		Formula formula = new Formula();
		int[] a = {1,-2,-3};
		int[] b = {2};
		int[] c = {-2};
		
		formula.addClause(makeClause(a));
		formula.addClause(makeClause(b));
		formula.addClause(makeClause(c));
		
		Formula expected = new Formula();
		int[] a1 = {1,-3};
		int[] b1 = {};
		
		expected.addClause(makeClause(a1));
		expected.addClause(makeClause(b1));
		
		Methods.unitPropagation(formula);
		
		assertEquals(expected,formula);
		
	}
	
	@Test 
	public void testEquals() {
		Formula notEqual = new Formula();
		int[] a = {1,2,3};
		notEqual.addClause(makeClause(a));
		
		Formula formula = new Formula();
		int[] b = {1,2};
		formula.addClause(makeClause(b));
		
		assertFalse(formula.equals(notEqual));
		
	}
	
	private Clause makeClause(int[] literals) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : literals) {
			list.add(i);
		}
		return new Clause(list);
	}

}
