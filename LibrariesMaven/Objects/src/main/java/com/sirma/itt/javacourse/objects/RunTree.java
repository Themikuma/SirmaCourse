package com.sirma.itt.javacourse.objects;

/**
 * This class runs a program using a homogeneous tree.
 * 
 * @author gdimitrov
 */
public final class RunTree {
	/**
	 * Private constructor for a utility class.
	 */
	private RunTree() {

	}

	/**
	 * The program uses integers to insert in the tree and prints them using the depth first search
	 * algorithm.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>(5);
		tree.getRoot().addChild(new TreeNode<Integer>(3));
		tree.getRoot().getChild(0).addChild(new TreeNode<Integer>(4));
		tree.getRoot().getChild(0).addChild(new TreeNode<Integer>(12));
		tree.getRoot().addChild(new TreeNode<Integer>(7));
		tree.getRoot().getChild(1).addChild(new TreeNode<Integer>(9));
		tree.printDFS();
	}
}
