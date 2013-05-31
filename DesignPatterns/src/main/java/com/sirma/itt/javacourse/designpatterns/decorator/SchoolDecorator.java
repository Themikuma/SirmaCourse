/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * Creates additional subjects for students to study.
 * 
 * @author Georgi
 */
public abstract class SchoolDecorator implements School {

	private final School modernSchool;

	/**
	 * Creates a school decorator using one of the implementing classes of {@link School}.
	 * 
	 * @param modernSchool
	 *            the object from a class implementing {@link School}.
	 */
	public SchoolDecorator(School modernSchool) {
		this.modernSchool = modernSchool;
	}

	@Override
	public String studyTechnicalSubjects() {
		return modernSchool.studyTechnicalSubjects();
	}

	@Override
	public String studyLanguages() {
		return modernSchool.studyLanguages();
	}

	/**
	 * Adds more languages.
	 * 
	 * @return the added languages.
	 */
	protected abstract String moreLanguages();

	/**
	 * Adds more technical subjects.
	 * 
	 * @return the added subjects.
	 */
	protected abstract String moreTechnicalSubjects();
}
