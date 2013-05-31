/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * A basic student that only wants to study math and Bulgarian.
 * 
 * @author Georgi
 */
public class BasicSchool implements School {

	@Override
	public String studyTechnicalSubjects() {
		return "I studied Math";
	}

	@Override
	public String studyLanguages() {
		return "I studied Bulgarian";
	}

}
