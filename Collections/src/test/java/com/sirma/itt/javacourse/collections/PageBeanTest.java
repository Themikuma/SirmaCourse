package com.sirma.itt.javacourse.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the PageBean class.
 * 
 * @author gdimitrov
 */
public class PageBeanTest {

	private ArrayList<Integer> input;
	private PageBean<Integer> bean;

	/**
	 * Sets up the tests with the same list to page.
	 */
	@Before
	public void setup() {
		int pageSize = 5;
		input = new ArrayList<Integer>();
		for (int i = 0; i < 31; i++) {
			input.add(i);
		}
		bean = new PageBean<Integer>(pageSize, input);
	}

	/**
	 * Tests the first page function.
	 */
	@Test
	public void testFirstPage() {
		List<Integer> expected = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			expected.add(i);
		}
		assertEquals(expected, bean.firstPage());
	}

	/**
	 * Tests the last page function.
	 */
	@Test
	public void testLastPage() {
		List<Integer> expected = new ArrayList<>();
		expected.add(30);
		assertEquals(expected, bean.lastPage());
	}

	/**
	 * Test the next function from the start.
	 */
	@Test
	public void testNextFromStart() {
		bean.next();
		bean.next();
		List<Integer> expected = new ArrayList<>();
		for (int i = 10; i < 15; i++) {
			expected.add(i);
		}
		assertEquals(expected, bean.next());

	}

	/**
	 * Test the next function from the end of the list. Should redisplay the last page.
	 */
	@Test
	public void testNextFromEnd() {
		bean.lastPage();
		List<Integer> expected = new ArrayList<>();
		expected.add(30);
		assertEquals(expected, bean.next());
	}

	/**
	 * Test the previous function, while on the first page.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testPreviousFromStart() {
		bean.previous();
	}

	/**
	 * Test the previous function, while on the last page.
	 */
	@Test
	public void testPreviousFromEnd() {
		bean.lastPage();
		List<Integer> expected = new ArrayList<>();
		for (int i = 25; i < 30; i++) {
			expected.add(i);
		}
		assertEquals(expected, bean.previous());
	}

	/**
	 * Test the hasNext function from the start.
	 */
	@Test
	public void testHasNextFromStart() {
		assertTrue(bean.hasNext());
	}

	/**
	 * Test the hasNext function from the end.
	 */
	@Test
	public void testHasNextFromEnd() {
		bean.lastPage();
		assertFalse(bean.hasNext());
	}

	/**
	 * Test the hasPrevious function from the start.
	 */
	@Test
	public void testHasPreviousFromStart() {
		assertFalse(bean.hasPrevious());
	}

	/**
	 * Test the hasPrevious function from the end.
	 */
	@Test
	public void testHasPreviousFromEnd() {
		bean.lastPage();
		assertTrue(bean.hasPrevious());
	}
}
