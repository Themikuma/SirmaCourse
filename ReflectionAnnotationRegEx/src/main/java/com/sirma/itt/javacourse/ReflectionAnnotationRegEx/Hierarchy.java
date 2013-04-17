package com.sirma.itt.javacourse.ReflectionAnnotationRegEx;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gdimitrov
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Hierarchy {
	/**
	 * The value of the annotation.
	 * 
	 * @return
	 */
	int value();
}
