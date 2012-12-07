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
		int[] clause1 = {1,-2,-3};
		int[] clause2 = {2};
		int[] clause3 = {-2};
		
		formula.addClause(MockMethods.makeClause(clause1));
		formula.addClause(MockMethods.makeClause(clause2));
		formula.addClause(MockMethods.makeClause(clause3));
		
		Formula expected = new Formula();
		int[] a1 = {1,-3};
		int[] b1 = {};
		
		expected.addClause(MockMethods.makeClause(a1));
		expected.addClause(MockMethods.makeClause(b1));
		
		Methods.unitPropagation(formula);
		
		assertEquals(expected,formula);
		
	}
	
	@Test 
	public void testEquals() {
		Formula notEqual = new Formula();
		int[] a = {1,2,3};
		notEqual.addClause(MockMethods.makeClause(a));
		
		Formula formula = new Formula();
		int[] b = {1,2};
		formula.addClause(MockMethods.makeClause(b));
		
		assertFalse(formula.equals(notEqual));
	}
	
	@Test
	public void testSplitting() {
		
		Formula formula = new Formula();
		int[] clause1 = {1, -3};
		int[] clause2 = {};
		formula.addClause(MockMethods.makeClause(clause1));
		formula.addClause(MockMethods.makeClause(clause2));
		
		assertTrue(Methods.splitting(formula));
	}
	
	@Test
	public void testDPLL() {
		Formula formula = new Formula();
		int[] clause1 = {1,-2,-3};
		int[] clause2 = {2};
		int[] clause3 = {-2};
		formula.addClause(MockMethods.makeClause(clause1));
		formula.addClause(MockMethods.makeClause(clause2));
		formula.addClause(MockMethods.makeClause(clause3));
		
		assertFalse(Methods.DPLL(formula));
	}

}
