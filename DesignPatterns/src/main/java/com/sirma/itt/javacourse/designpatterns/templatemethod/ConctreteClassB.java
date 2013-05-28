package com.sirma.itt.javacourse.designpatterns.templatemethod;

/**
 * This class implements the abstract methods of {@link AbstractClass}.
 * 
 * @author gdimitrov
 */
public class ConctreteClassB extends AbstractClass {

	@Override
	public int doMoreWork(int operand) {
		return operand - 1;
	}

}
