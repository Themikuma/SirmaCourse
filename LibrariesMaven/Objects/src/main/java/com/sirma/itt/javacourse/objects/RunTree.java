package com.sirma.itt.javacourse.objects;

/**
 * This class runs the heterogeneous tree
 * 
 * @author gdimitrov
 */
public class RunTree {
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
