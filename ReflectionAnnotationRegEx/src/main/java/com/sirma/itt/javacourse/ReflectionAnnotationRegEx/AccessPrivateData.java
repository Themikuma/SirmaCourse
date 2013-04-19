package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * A class that accesses private class data.
 * 
 * @author gdimitrov
 */
public final class AccessPrivateData {
	/**
	 * Private constructor for utility classes.
	 */
	private AccessPrivateData() {
	}

	/**
	 * Gets a method by an object instance and the method name.
	 * 
	 * @param obj
	 *            instance of an object
	 * @param methodName
	 *            the name of the method to get
	 * @return the method.
	 */
	public static Object getMethod(Object obj, String methodName) {
		Method method;
		try {
			method = obj.getClass().getDeclaredMethod("privateMethod", null);
			method.setAccessible(true);
			return method;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method gets the private fields for the class.
	 * 
	 * @param obj
	 *            the object whose private properties are going to be accessed.
	 * @param fieldName
	 *            the name of the field
	 * @return the field.
	 */
	public static Object getProperty(Object obj, String fieldName) {
		try {
			Field privateField = obj.getClass().getDeclaredField(fieldName);
			privateField.setAccessible(true);
			return privateField.get(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
}
