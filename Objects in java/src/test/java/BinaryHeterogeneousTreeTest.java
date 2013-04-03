package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import main.java.BinaryHeterogeneousTree;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeterogeneousTreeTest {
	private BinaryHeterogeneousTree tree;

	/**
	 * Initialize the tree structure before each test
	 */
	@Before
	public void testSetup() {
		tree = new BinaryHeterogeneousTree();
		int i = 1;
		int j = 5;
		String s = "seven";
		String p = "five";
		String d = "two";
		String c = "FOUR!!!!";
		tree.insert(i);
		tree.insert(c);
		tree.insert(d);
		tree.insert(s);
		tree.insert(j);
		tree.insert(p);
	}

	/**
	 * Trying to add "two" to the tree again. Should fail throwing an IllegalArgumentException with
	 * a message "Duplicate items"
	 */
	@Test
	public void testAddDuplicateElement() {
		Throwable caught = null;
		try {
			tree.insert("two");
		} catch (Exception e) {
			caught = e;
		}
		assertEquals("Duplicate items", caught.getMessage());
	}

	/**
	 * Searching for an object that has the same items as an added object, but is not the same
	 * object. Should not find the object
	 */
	@Test
	public void testSearchFail() {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		arrayList.add(34);
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(2);
		arrayList2.add(34);
		tree.insert(arrayList);
		assertTrue(!tree.search(arrayList2));
	}

	/**
	 * Searching for an object that has been added previously to the tree. Should find it.
	 */
	@Test
	public void testSearchSuccess() {
		assertTrue(tree.search("two"));

	}
}
