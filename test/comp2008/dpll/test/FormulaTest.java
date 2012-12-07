package comp2008.dpll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import comp2008.dpll.Clause;
import comp2008.dpll.Formula;

public class FormulaTest {

	private Formula formula;

	@Before
	public void setUp() throws Exception {
		int[] a = { 1, 2, 3 };
		int[] b = { -1, 2 };
		int[] c = { -1 };

		Clause c1 = MockMethods.makeClause(a);
		Clause c2 = MockMethods.makeClause(b);
		Clause c3 = MockMethods.makeClause(c);

		formula = new Formula(3, 3);
		formula.addClause(c1);
		formula.addClause(c2);
		formula.addClause(c3);

	}

	@Test
	public void testFindUnit() {
		int expected = -1;
		assertEquals(expected, formula.findUnit());
	}

	@Test
	public void testSimplifyUnit() {
		
		int[] a = {2};
		int[] b = {};

		Clause clause1 = MockMethods.makeClause(a);
		Clause clause2 = MockMethods.makeClause(b);

		Formula expected = new Formula();
		expected.addClause(clause1);
		expected.addClause(clause2);
		
		formula.simplifyUnit(1);
		
		formula.printAllClauses();
		
		assertTrue(formula.getClauses().equals(expected.getClauses()));

	}

	@Test
	public void testHasEmptyClause() {
		assertFalse(formula.hasEmptyClause());
	}

	@Test
	public void testClone() {
		Formula formula = new Formula();
		int[] a = {1,2,3};
		formula.addClause(MockMethods.makeClause(a));
		
		Formula clone = new Formula(formula);
		int[] b = {1,2};
		clone.addClause(MockMethods.makeClause(b));
		
		assertTrue(formula.getClauses().size() == 1);
		assertTrue(clone.getClauses().size() == 2);
	}

}
