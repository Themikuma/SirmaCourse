/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * @author Georgi
 */
public class ProperDecorator extends SchoolDecorator {

	/**
	 * Creates a decorator using an object from a class implementing {@link School}.
	 * 
	 * @param privateSchool
	 *            the object from a class implementing {@link School}
	 */
	public ProperDecorator(School privateSchool) {
		super(privateSchool);
	}

	@Override
	public String studyLanguages() {
		return super.studyLanguages() + moreLanguages();
	}

	@Override
	public String studyTechnicalSubjects() {
		return super.studyTechnicalSubjects() + moreTechnicalSubjects();
	}

	@Override
	protected String moreLanguages() {
		return " and English";
	}

	@Override
	protected String moreTechnicalSubjects() {
		return " and Computer science";
	}

}
