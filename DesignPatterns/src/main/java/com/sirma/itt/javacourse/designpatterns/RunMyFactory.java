package com.sirma.itt.javacourse.designpatterns;

import java.util.Map;

/**
 * Contains an entry point method to run the factory pattern.
 * 
 * @author gdimitrov
 */
public final class RunMyFactory {
	/**
	 * Private constructor for utility classes.
	 */
	private RunMyFactory() {

	}

	/**
	 * The entry point method used to run MyFactory class.
	 * 
	 * @param args
	 *            - array of command-line arguments passed to this method.
	 */
	public static void main(String[] args) {
		Map<String, String> createMap = MyFactory.createMap("tree");
		System.out.println(createMap.getClass());
		Object reflection = MyFactory.createObjectByReflection("java.util.ArrayList");
		System.out.println(reflection.getClass());
	}

}
