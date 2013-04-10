package com.sirma.itt.javacourse.objects;

/**
 * A homogeneous tree.
 * 
 * @param <T>
 *            the type of elements that the tree will hold
 * @author gdimitrov
 */
public class Tree<T> {
	private TreeNode<T> root;

	/**
	 * Contstructor for the tree of the tree.
	 * 
	 * @param value
	 *            the value of the root
	 */
	public Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null");
		}
		this.root = new TreeNode<T>(value);
	}

	/**
	 * Print the entire tree using the depth first search algorithm.
	 * 
	 * @param node
	 *            the current node that is being searched.
	 */
	private void printDFS(TreeNode<T> node) {
		if (this.root == null) {
			return;
		}
		TreeNode<T> child = null;
		for (int i = 0; i < node.childrenCount(); i++) {
			child = node.getChild(i);
			printDFS(child);
		}
		System.out.println(node.getValue());
	}

	/**
	 * The call to the recursive function, for easier user access.
	 */
	public void printDFS() {
		this.printDFS(this.root);
	}

	/**
	 * @return the root of the tree
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

}
