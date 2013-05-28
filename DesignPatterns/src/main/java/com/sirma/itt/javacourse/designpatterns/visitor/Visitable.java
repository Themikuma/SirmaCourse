package com.sirma.itt.javacourse.designpatterns.visitor;

/**
 * The implementing classes accept a visitor.
 * 
 * @author gdimitrov
 */
public interface Visitable {
	/**
	 * Accepts a visitor to perform an action on the object.
	 * 
	 * @param visitor
	 *            the visitor performing the actions.
	 */
	void accept(Visitor visitor);
}
