package comp2008.dpll.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import comp2008.dpll.Clause;

public class ClauseTest {
	
	Clause clause;

	@Before
	public void setUp() {
		int[] a = {-1,2,-3};
		
		clause = makeClause(a);
	}
	
	@Test
	public void testContains() {
		int expected = -1;
		assertTrue(clause.contains(expected));
	}

	@Test
	public void testRemoveLiteral() {
		int[] a = {2,-3};
		Clause expected = makeClause(a);
		clause.removeLiteral(-1);
		assertEquals(clause,expected);
	}

	@Test
	public void testIsEmpty() {
		assertFalse(clause.isEmpty());
		Clause emptyClause = new Clause();
		assertTrue(emptyClause.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(3,clause.size());
	}

	@Test
	public void testGetFirstLiteral() {
		assertEquals(-1,clause.getFirstLiteral());
	}
	
	private Clause makeClause(int[] literals) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i : literals) {
			list.add(i);
		}
		return new Clause(list);
	}

}
