package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Gets information about the dummy class.
 * 
 * @author gdimitrov
 */
public final class ClassInfo {
	/**
	 * Private constructor for utility classes.
	 */
	private ClassInfo() {
	}

	/**
	 * @param obj
	 *            the instance of a class whose information is being obtained.
	 */
	public static void getInfo(Object obj) {
		Class<?> c = obj.getClass();
		Field[] field = c.getDeclaredFields();
		Method[] method = c.getDeclaredMethods();
		System.out.println("Methods:");
		for (Method m : method) {
			System.out.println(m);
		}
		System.out.println("Fields:");
		for (Field f : field) {
			System.out.println(f);
		}
	}
}
