package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

/**
 * Runs a program that uses a binary heterogeneous tree.
 * 
 * @author gdimitrov
 */
public final class RunBinaryHeterogeneousTree {
	/**
	 * Private constructor for an utility class.
	 */
	private RunBinaryHeterogeneousTree() {

	}

	/**
	 * A program that uses a binary heterogeneous tree, to insert elements of a different type in
	 * the same tree.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		BinaryHeterogeneousTree tree = new BinaryHeterogeneousTree();
		int i = 1;
		int j = 5;
		String s = "seven";
		String p = "five";
		String d = "two";
		String c = "FOUR!!!!";
		tree.insert(i);
		tree.insert(c);
		tree.insert(d);
		tree.insert(s);
		tree.insert(j);
		tree.insert(p);
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		arrayList.add(34);
		ArrayList<Integer> arrayList2 = new ArrayList<>();
		arrayList2.add(2);
		arrayList2.add(34);
		tree.insert(arrayList);
		// System.out.println(System.identityHashCode(arrayList) + "; " +
		// System.identityHashCode(d));
		System.out.println(tree.printTree());
		if (tree.search(arrayList2)) {
			System.out.println("Found");
		} else {
			System.out.println("Not found");
		}
	}
}
