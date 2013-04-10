package com.sirma.itt.javacourse.objects;

/**
 * A class to run a program that uses a binary tree.
 * 
 * @author gdimitrov
 */
public final class RunBinaryTree {
	/**
	 * Private constructor for a utility class.
	 */
	private RunBinaryTree() {

	}

	/**
	 * Uses a binary tree to insert some numbers and display them sorted and search for a number.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		String printSorted = new String();
		BinaryTree btree = new BinaryTree();
		int[] arr = { 6, 2, 4, 9, 21, 3 };
		for (int i : arr) {
			System.out.println("Inserting " + i);
			btree.insert(i);
		}
		if (btree.search(3)) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
		printSorted = btree.printTree();
		System.out.println("Sorted tree " + printSorted);
	}
}
