package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

/**
 * A single node from the tree.
 * 
 * @param <T>
 *            the type of the node.
 * @author gdimitrov
 */
public class TreeNode<T> {
	private T value;
	private ArrayList<TreeNode<T>> children;
	private boolean hasParent;

	/**
	 * Constructor for a node of the tree.
	 * 
	 * @param value
	 *            the value of the node
	 */
	public TreeNode(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null");
		}
		this.setValue(value);
		hasParent = false;
		this.children = new ArrayList<TreeNode<T>>();
	}

	/**
	 * adds the given TreeNode<T> to the tree structure.
	 * 
	 * @param child
	 *            - TreeNode<T> to be added
	 */
	public void addChild(TreeNode<T> child) {
		if (child == null) {
			throw new IllegalArgumentException("Cannot insert null");
		}
		if (child.hasParent) {
			throw new IllegalArgumentException("Child already has a parent");
		}
		this.children.add(child);
		child.hasParent = true;
	}

	/**
	 * @return the value of the current node
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Get the children count.
	 * 
	 * @return children count
	 */
	public int childrenCount() {
		return this.children.size();
	}

	/**
	 * Get the child at index.
	 * 
	 * @param index
	 *            the index of the child
	 * @return the child
	 */
	public TreeNode<T> getChild(int index) {
		return this.children.get(index);
	}

}
