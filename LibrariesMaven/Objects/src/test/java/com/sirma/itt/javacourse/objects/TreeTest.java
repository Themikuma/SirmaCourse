package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests on the heterogeneous tree.
 * 
 * @author gdimitrov
 */
public class TreeTest {
	private Tree<String> tree;

	/**
	 * Setup for all the tests.
	 */
	@Before
	public void setup() {
		tree = new Tree<String>("Root");
		tree.getRoot().addChild(new TreeNode<String>("leaf"));
	}

	/**
	 * This test adds an element and then asserts if the element is added in the right position.
	 */
	@Test
	public void testAddElement() {
		tree.getRoot().addChild(new TreeNode<String>("leaf2"));
		String value = tree.getRoot().getChild(1).getValue();
		assertEquals(value, "leaf2");
	}

	/**
	 * This test tries to add the same node twice which causes an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddElementFail() {
		TreeNode<String> node = new TreeNode<String>("leaf");
		tree.getRoot().addChild(node);
		tree.getRoot().addChild(node);
	}

	/**
	 * This test tries to add a null element which causes an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddElementNull() {
		tree.getRoot().addChild(new TreeNode<String>(null));
	}
}
