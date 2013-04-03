package main.java;

/**
 * A realization of the binary search tree for all objects. It has implemented methods for
 * inserting, printing all the elements sorting them by their hash codes and searching for a given
 * element
 * 
 * @author gdimitrov
 */
public class BinaryHeterogeneousTree {
	private BinaryHeterogeneousTreeNode root;

	/**
	 * This class implements a single node in the tree
	 */
	private class BinaryHeterogeneousTreeNode implements Comparable<Object> {
		private Object value;
		private BinaryHeterogeneousTreeNode leftChild;
		private BinaryHeterogeneousTreeNode rightChild;

		public BinaryHeterogeneousTreeNode(Object value) {
			this.value = value;
			leftChild = null;
			rightChild = null;
		}

		@Override
		public int compareTo(Object o) {
			if (System.identityHashCode(this.value) > System.identityHashCode(o)) {
				return 1;
			}
			if (System.identityHashCode(this.value) < System.identityHashCode(o)) {
				return -1;
			}
			return 0;
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
			if (currentNode.compareTo(value) == -1) {
				currentNode.rightChild = insert(value, currentNode.rightChild);
			} else if (currentNode.compareTo(value) == 1) {
				currentNode.leftChild = insert(value, currentNode.leftChild);
			} else {
				throw new IllegalArgumentException("Duplicate items");
			}
		}
		return currentNode;
	}

	/**
	 * Prints the objects in the tree sorted by hash code from lowest to highest.
	 * 
	 * @return the tree as a sorted string
	 */
	public String printTree() {
		return printTree(this.root);
	}

	/**
	 * The actual implementation of the printTree function
	 * 
	 * @param currentNode
	 *            - the current node that is being checked
	 * @return the sorted string so far.
	 */
	private String printTree(BinaryHeterogeneousTreeNode currentNode) {
		StringBuilder builder = new StringBuilder();
		if (currentNode.leftChild != null) {
			builder.append(printTree(currentNode.leftChild));
		}
		builder.append(currentNode.value + " ");
		if (currentNode.rightChild != null) {
			builder.append(printTree(currentNode.rightChild));
		}
		return builder.toString();
	}

	public boolean search(Object value) {
		return search(this.root, value);
	}

	/**
	 * @param currentNode
	 *            - the node that is being checked in this call
	 * @param value
	 *            - the value that's being searched for
	 * @return True if the value was found.
	 */
	private boolean search(BinaryHeterogeneousTreeNode currentNode, Object value) {
		if (currentNode.compareTo(value) == 0) {
			return true;
		}
		if ((currentNode.compareTo(value) == 1) && (currentNode.leftChild != null)) {
			return search(currentNode.leftChild, value);
		} else if ((currentNode.compareTo(value) == -1) && (currentNode.rightChild != null)) {
			return search(currentNode.rightChild, value);
		}
		return false;
	}

}
