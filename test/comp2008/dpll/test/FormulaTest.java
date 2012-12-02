package comp2008.dpll.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		int[] c = { 1 };

		Clause c1 = makeClause(a);
		Clause c2 = makeClause(b);
		Clause c3 = makeClause(c);

		formula = new Formula(3, 3);
		formula.addClause(c1);
		formula.addClause(c2);
		formula.addClause(c3);

	}

	@Test
	public void testFindUnit() {
		int expected = 1;
		assertEquals(expected, formula.findUnit());
	}

	@Test
	public void testSimplifyUnit() {
		int[] a = { 1, 3 };
		int[] b = { -1 };
		int[] c = { 1 };

		Clause c1 = makeClause(a);
		Clause c2 = makeClause(b);
		Clause c3 = makeClause(c);

		Formula expected = new Formula(3, 3);
		expected.addClause(c1);
		expected.addClause(c2);
		expected.addClause(c3);

		formula.simplifyUnit(2);

		assertTrue(formula.getClauses().equals(expected.getClauses()));

	}

	@Test
	public void testUnitPropagation() {
		fail("Not yet implemented.");
	}

	private Clause makeClause(int[] literals) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : literals) {
			list.add(i);
		}
		return new Clause(list);
	}

}
