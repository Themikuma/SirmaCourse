package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

/**
 * This class provides a method to sort classes using an annotation.
 * 
 * @author gdimitrov
 */
public final class SortCustomHierarchy {
	/**
	 * Private constructor for utility classes.
	 */
	private SortCustomHierarchy() {
	}

	/**
	 * Sorts the instances of the classes using their annotations.
	 * 
	 * @param args
	 *            the instances of classes to be sorted.
	 * @return sorted array.
	 */
	public static CustomParent[] sort(CustomParent... args) {
		CustomParent buffer = new CustomParent();
		for (int i = 0; i < args.length; i++) {
			for (int j = i + 1; j < args.length; j++) {
				Class<? extends CustomParent> class1 = args[i].getClass();
				Hierarchy hierarchy = class1.getAnnotation(Hierarchy.class);
				int hierarchyValue1 = hierarchy.value();
				Class<? extends CustomParent> class2 = args[j].getClass();
				Hierarchy hierarchy2 = class2.getAnnotation(Hierarchy.class);
				int hierarchyValue2 = hierarchy2.value();
				if (hierarchyValue2 < hierarchyValue1) {
					buffer = args[j];
					args[j] = args[i];
					args[i] = buffer;
				}
			}
		}
		return args;
	}
}
