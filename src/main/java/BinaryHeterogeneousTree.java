package main.java;

/**
 * A realization of the binary search tree. It has implemented methods for inserting, printing all
 * the elements sorted and searching for a given element
 * 
 * @author gdimitrov
 */
public class BinaryHeterogeneousTree {
	private BinaryHeterogeneousTreeNode root;

	/**
	 * This class implements a single node in the tree
	 */
	private class BinaryHeterogeneousTreeNode {
		private Object value;
		private BinaryHeterogeneousTreeNode leftChild;
		private BinaryHeterogeneousTreeNode rightChild;

		public BinaryHeterogeneousTreeNode(Object value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}
	}

	public BinaryHeterogeneousTree() {
		this.root = null;
	}

	/**
	 * Inserts a value in the tree
	 * 
	 * @param value
	 *            - value to be inserted
	 */
	public void insert(Object value) {
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
	private BinaryHeterogeneousTreeNode insert(Object value, BinaryHeterogeneousTreeNode currentNode) {
		if (currentNode == null) {
			currentNode = new BinaryHeterogeneousTreeNode(value);
		} else {
			if (value.hashCode() > currentNode.value.hashCode()) {
				currentNode.rightChild = insert(value, currentNode.rightChild);
			} else if (value.hashCode() < currentNode.value.hashCode()) {
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
	public String printTree() {
		return sortTree(this.root);
	}

	/**
	 * The actual implementation of the sortTree function
	 * 
	 * @param currentNode
	 *            - the current node that is being checked
	 * @return the sorted string so far.
	 */
	private String sortTree(BinaryHeterogeneousTreeNode currentNode) {
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

}
