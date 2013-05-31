/**
 * 
 */
package com.sirma.itt.javacourse.designpatterns.bridge;

/**
 * @author Georgi
 */
public interface Implementor {
	/**
	 * Does some of the work.
	 * 
	 * @return some result from the work performed.
	 */
	int doSomeWork();

	/**
	 * Does more work.
	 */
	void doMoreWork();

}
