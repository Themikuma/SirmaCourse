package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

/**
 * Contains a method that allows the user to instantiate a class by its name.
 * 
 * @author gdimitrov
 */
public final class InstantiateByName {
	/**
	 * Private constructor for utility classes.
	 */
	private InstantiateByName() {
	}

	/**
	 * Instantiates and gets the superclass and implemented interfaces for a class by name.
	 * 
	 * @param name
	 *            the name of the class.
	 * @return an instance of the object.
	 * @throws ClassNotFoundException
	 *             {@link ClassNotFoundException}
	 */
	public static Object getInstanceByName(String name) throws ClassNotFoundException {
		Object instance = null;
		Class<?> c = Class.forName(name);
		try {
			instance = c.newInstance();
			System.out.println("Instantiated by name:");
			System.out.println(instance.getClass());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Superclass:");
		System.out.println(c.getSuperclass());

		System.out.println("Interfaces:");
		Class<?>[] classes = c.getInterfaces();
		for (Class<?> class1 : classes) {
			System.out.println(class1);
		}
		return instance;
	}
}
