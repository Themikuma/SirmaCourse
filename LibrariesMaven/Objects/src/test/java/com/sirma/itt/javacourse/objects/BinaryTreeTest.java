package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.sirma.itt.javacourse.objects.BinaryTree;

public class BinaryTreeTest {
	private BinaryTree Btree;

	@Before
	public void setup() {
		Btree = new BinaryTree();
		Btree.insert(5);
		Btree.insert(3);
		Btree.insert(4);
		Btree.insert(13);
		Btree.insert(15);
		Btree.insert(1);
	}

	/**
	 * This test tries to add an element for the second time. It should get an exception
	 */
	@Test
	public void testAddDuplicateElement() {
		Throwable caught = null;
		try {
			Btree.insert(5);
		} catch (Exception e) {
			caught = e;
		}
		assertEquals("Duplicate items", caught.getMessage());
	}

	/**
	 * This test prints out the sorted items from the tree.
	 */
	@Test
	public void testSortTree() {
		String printSorted = new String();
		printSorted = Btree.sortTree();
		assertEquals("1 3 4 5 13 15 ", printSorted);
	}

	/**
	 * This test searches for an element that exists in the tree
	 */
	@Test
	public void testFound() {
		assertTrue(Btree.search(3));
	}

	/**
	 * This test searches for an element that doesn't exist in the tree
	 */
	@Test
	public void testNotFound() {
		assertTrue(!Btree.search(2));
	}

}
