/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * Demonstrates the decorator pattern.
 * 
 * @author Georgi
 */
public final class Demo {

	/**
	 * Private constructor for utility classes.
	 */
	private Demo() {
	}

	/**
	 * Entry point method for the class.
	 * 
	 * @param args
	 *            array of command-line arguments passed by the user.
	 */
	public static void main(String[] args) {
		// This is a non decorated school.
		School basicSchool = new BasicSchool();
		System.out.println(basicSchool.studyLanguages());
		System.out.println(basicSchool.studyTechnicalSubjects());

		// A properly decorated school.
		School properlSchool = new ProperDecorator(new BasicSchool());
		System.out.println(properlSchool.studyLanguages());
		System.out.println(properlSchool.studyTechnicalSubjects());

		// How a school is actually decorated.
		School actualSchool = new ActualDecorator(new BasicSchool());
		System.out.println(actualSchool.studyLanguages());
		System.out.println(actualSchool.studyTechnicalSubjects());

	}
}
