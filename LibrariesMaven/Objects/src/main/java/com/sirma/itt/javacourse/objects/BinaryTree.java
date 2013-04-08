package com.sirma.itt.javacourse.objects;

/**
 * A realization of the binary search tree. It has implemented methods for inserting, printing all
 * the elements sorted and searching for a given element
 * 
 * @author gdimitrov
 */
public class BinaryTree {
	private BinaryTreeNode root;

	/**
	 * This class implements a single node in the tree
	 */
	private class BinaryTreeNode {
		private int value;
		private BinaryTreeNode leftChild;
		private BinaryTreeNode rightChild;

		public BinaryTreeNode(int value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}
	}

	/**
	 * Constructor that sets the root to null
	 */

	public BinaryTree() {
		this.root = null;
	}

	/**
	 * Inserts a value in the tree
	 * 
	 * @param value
	 *            - value to be inserted
	 */
	public void insert(int value) {
		this.root = insert(value, root);
	}

	/**
	 * The actual implementation of the insert function.
	 * 
	 * @param value
	 *            - the value to be inserted
	 * @param currentNode
	 *            - the current node that is being checked
	 * @return the configured node
	 */
	private BinaryTreeNode insert(int value, BinaryTreeNode currentNode) {
		if (currentNode == null) {
			currentNode = new BinaryTreeNode(value);
		} else {
			if (value > currentNode.value) {
				currentNode.rightChild = insert(value, currentNode.rightChild);
			} else if (value < currentNode.value) {
				currentNode.leftChild = insert(value, currentNode.leftChild);
			} else {
				throw new IllegalArgumentException("Duplicate items");
			}
		}
		return currentNode;
	}

	/**
	 * Sorts the tree from lowest to highest.
	 * 
	 * @return the tree as a sorted string
	 */
	public String sortTree() {
		return sortTree(this.root);
	}

	/**
	 * The actual implementation of the sortTree function
	 * 
	 * @param currentNode
	 *            - the current node that is being checked
	 * @return the sorted string so far.
	 */
	private String sortTree(BinaryTreeNode currentNode) {
		StringBuilder builder = new StringBuilder();
		if (currentNode.leftChild != null) {
			builder.append(sortTree(currentNode.leftChild));
		}
		builder.append(currentNode.value + " ");
		if (currentNode.rightChild != null) {
			builder.append(sortTree(currentNode.rightChild));
		}
		return builder.toString();
	}

	/**
	 * Determines whether or not a given value is found in the tree
	 * 
	 * @param value
	 *            - the value that's being searched for
	 * @return True if the value was found.
	 */
	public boolean search(int value) {
		return search(this.root, value);
	}

	/**
	 * @param currentNode
	 *            - the node that is being checked in this call
	 * @param value
	 *            - the value that's being searched for
	 * @return True if the value was found.
	 */
	private boolean search(BinaryTreeNode currentNode, int value) {
		if (currentNode.value == value) {
			return true;
		}
		if ((currentNode.value > value) && (currentNode.leftChild != null)) {
			return search(currentNode.leftChild, value);
		} else if ((currentNode.value < value) && (currentNode.rightChild != null)) {
			return search(currentNode.rightChild, value);
		}
		return false;
	}
}
