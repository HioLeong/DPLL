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

		Clause a1 = MockMethods.makeClause(a);
		Clause b1 = MockMethods.makeClause(b);

		Formula expected = new Formula(3, 3);
		expected.addClause(a1);
		expected.addClause(b1);

		formula.simplifyUnit(1);

		assertEquals(formula,expected);

	}

	@Test
	public void testHasEmptyClause() {
		assertFalse(formula.hasEmptyClause());
	}



}
