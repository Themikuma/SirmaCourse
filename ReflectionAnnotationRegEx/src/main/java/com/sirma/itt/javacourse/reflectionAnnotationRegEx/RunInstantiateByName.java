package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gdimitrov
 */
public final class RunInstantiateByName {
	/**
	 * Private constructor for abstract classes.
	 */
	private RunInstantiateByName() {
	}

	/**
	 * Run the InstatiateByName class.
	 * 
	 * @param args
	 *            array of command-line arguments passed to this method
	 * @throws ClassNotFoundException
	 *             {@link ClassNotFoundException}
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println("Enter the name of the class you want to get information about:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Object obj = InstantiateByName.getInstanceByName(line);
		ClassInfo.getInfo(obj);
	}

}
