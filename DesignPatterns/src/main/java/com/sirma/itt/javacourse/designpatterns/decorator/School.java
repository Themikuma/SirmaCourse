/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.decorator;

/**
 * This interface describes what general studies should there be in school.
 * 
 * @author Georgi
 */
public interface School {

	/**
	 * Makes the student study technical subjects.
	 * 
	 * @return the subjects the students study.
	 */
	String studyTechnicalSubjects();

	/**
	 * Makes the student study languages.
	 * 
	 * @return the subjects the students study.
	 */
	String studyLanguages();
}
