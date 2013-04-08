package com.sirma.itt.javacourse.objects;

import java.util.ArrayList;

import com.sirma.itt.javacourse.objects.BinaryHeterogeneousTree;

public class RunBinaryHeterogeneousTree {

	/**
	 * @param args
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
