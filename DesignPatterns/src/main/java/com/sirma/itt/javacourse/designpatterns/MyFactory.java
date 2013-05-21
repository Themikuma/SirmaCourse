package com.sirma.itt.javacourse.designpatterns;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Instantiates an object by using the abstract factory pattern.
 * 
 * @author gdimitrov
 */
public final class MyFactory {

	/**
	 * Private constructor for utility classes.
	 */
	private MyFactory() {
	}

	/**
	 * Creates a {@link Map} based on the type.
	 * 
	 * @param type
	 *            - the exact implementation of {@link Map}.
	 * @return a concrete implementation of {@link Map}.
	 */
	public static Map<String, String> createMap(String type) {
		if ("hash".equals(type)) {
			return new HashMap<String, String>();
		} else if ("tree".equals(type)) {
			return new TreeMap<String, String>();
		}
		return null;
	}

	/**
	 * Creates an object, by using reflection. If the class name isn't valid the method returns
	 * null.
	 * 
	 * @param className
	 *            the class name of the object to create.
	 * @return instance of the object or null.
	 */
	public static Object createObjectByReflection(String className) {
		try {
			Class<?> c = Class.forName(className);
			return c.newInstance();
		} catch (ClassNotFoundException e) {
			return null;
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
}
