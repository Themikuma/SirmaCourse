package com.sirma.itt.javacourse.objects;


/**
 * Runs a main method that uses the binary tree
 * 
 * @author gdimitrov
 */
public class RunBinaryTree {
	public static void main(String[] args) {
		String printSorted = new String();
		BinaryTree Btree = new BinaryTree();
		int[] arr = { 6, 2, 4, 9, 21, 3 };
		for (int i : arr) {
			System.out.println("Inserting " + i);
			Btree.insert(i);
		}
		if (Btree.search(3)) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
		printSorted = Btree.sortTree();
		System.out.println("Sorted tree " + printSorted);
	}
}
