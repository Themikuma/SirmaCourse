package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gdimitrov
 */
public final class AccessPrivateData {
	/**
	 * Private constructor for utility classes.
	 */
	private AccessPrivateData() {

	}

	/**
	 * This method gets the private fields for the class.
	 * 
	 * @param dummy
	 *            the object whose private properties are going to be accessed.
	 */
	public static void getPrivateFields(Dummy dummy) {
		try {
			Method method = dummy.getClass().getDeclaredMethod("privateMethod", null);
			method.setAccessible(true);
			method.invoke(dummy, null);
			Field privateField = dummy.getClass().getDeclaredField("privateProperty");
			privateField.setAccessible(true);
			System.out.println(privateField.get(dummy));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
}
