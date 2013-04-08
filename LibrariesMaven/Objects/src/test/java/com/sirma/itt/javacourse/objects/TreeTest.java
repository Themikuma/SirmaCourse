package com.sirma.itt.javacourse.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.objects.Tree;
import com.sirma.itt.javacourse.objects.TreeNode;

/**
 * @author gdimitrov
 */
public class TreeTest {
	/**
	 * This test adds an element and then asserts if the element is added in the right position
	 */
	@Test
	public void testAddElement() {
		Tree<String> tree = new Tree<String>("Root");
		tree.getRoot().addChild(new TreeNode<String>("leaf"));
		String value = tree.getRoot().getChild(0).getValue();
		assertEquals(value, "leaf");
	}

	/**
	 * This test tries to add the same node twice which causes an exception
	 */
	@Test
	public void testAddElementFail() {
		Tree<String> tree = new Tree<String>("Root");
		TreeNode<String> node = new TreeNode<String>("leaf");
		Throwable caught = null;
		tree.getRoot().addChild(node);
		try {
			tree.getRoot().addChild(node);
		} catch (Exception e) {
			caught = e;
		}
		assertEquals("Child already has a parent", caught.getMessage());
	}

	/**
	 * This test tries to add a null element which causes an exception
	 */
	@Test
	public void testAddElementNull() {
		Tree<String> tree = new Tree<String>("Root");
		TreeNode<String> node = new TreeNode<String>("leaf");
		Throwable caught = null;
		tree.getRoot().addChild(node);
		try {
			tree.getRoot().addChild(null);
		} catch (Exception e) {
			caught = e;
		}
		assertEquals("Cannot insert null", caught.getMessage());
	}
}
