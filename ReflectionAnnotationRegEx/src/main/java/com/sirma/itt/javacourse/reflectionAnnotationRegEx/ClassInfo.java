package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

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
	 * Gets information about a class's methods and fields.
	 * 
	 * @param obj
	 *            the instance of a class whose information is being obtained.
	 */
	public static void getInfo(Object obj) {
		Class<?> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println("Methods:");
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("Fields:");
		for (Field field : fields) {
			System.out.println(field);
		}
	}
}
