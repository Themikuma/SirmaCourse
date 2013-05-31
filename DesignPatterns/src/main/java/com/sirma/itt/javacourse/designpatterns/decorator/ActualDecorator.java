/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * The actual way the school curriculum is extended.
 * 
 * @author Georgi
 */
public class ActualDecorator extends SchoolDecorator {

	/**
	 * Creates a decorator using an object from a class implementing {@link School}.
	 * 
	 * @param privateSchool
	 *            the object from a class implementing {@link School}
	 */
	public ActualDecorator(School privateSchool) {
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
		return " and turkish";
	}

	@Override
	protected String moreTechnicalSubjects() {
		return " and history of the pickaxe";
	}

}
