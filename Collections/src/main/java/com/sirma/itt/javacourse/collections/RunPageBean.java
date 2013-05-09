package com.sirma.itt.javacourse.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Runs the page bean in the console.
 * 
 * @author gdimitrov
 */
public final class RunPageBean {

	/**
	 * Private constructors for utility classes.
	 */
	private RunPageBean() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
		char c = 0;
		int pageSize = 5;
		ArrayList<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < 31; i++) {
			input.add(i);
		}
		PageBean bean = new PageBean(pageSize, input);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (c != '.') {
			try {
				c = (char) br.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (c) {
				case 'n':
					System.out.println(bean.next().toString());
					break;
				case 'p':
					System.out.println(bean.previous().toString());
					break;
				case 'h':
					System.out.println(bean.hasNext());
					break;
				case 'j':
					System.out.println(bean.hasPrevious());
					break;
				case 'f':
					System.out.println(bean.firstPage());
					break;
				case 'l':
					System.out.println(bean.lastPage());
					break;
				case 'c':
					System.out.println(bean.getCurrentPageNumber());
					break;
				default:
					break;
			}
		}
	}
}
