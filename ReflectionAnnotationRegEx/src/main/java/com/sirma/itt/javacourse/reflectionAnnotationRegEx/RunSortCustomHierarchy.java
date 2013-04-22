package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

/**
 * Runs the sort for the custom hierarchy.
 * 
 * @author gdimitrov
 */
public final class RunSortCustomHierarchy {
	/**
	 * Private constructors for utility classes.
	 */
	private RunSortCustomHierarchy() {
	}

	/**
	 * @param args
	 *            array of command-line arguments passed to this method
	 */
	public static void main(String[] args) {
		CustomParent[] out = SortCustomHierarchy.sort(new CustomParent(), new FirstChild(),
				new CustomParent(), new SecondChild(), new FourthChild(), new ThirdChild());
		for (CustomParent customParent : out) {
			System.out.println(customParent.getClass());
		}
	}

}
