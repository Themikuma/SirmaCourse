package com.sirma.itt.javacourse.reflectionAnnotationRegEx;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests the ReplaceText class.
 * 
 * @author gdimitrov
 */
public class ReplaceTextTest {
	/**
	 * Tests the replace function by replacing the entire text.
	 */
	@Test
	public void testReplaceTextEntireText() {
		assertEquals("<x/>", ReplaceText.replace("<x>this text will magically go away</x>"));
	}

	/**
	 * Tests the replace function by replacing some of the text.
	 */
	@Test
	public void testReplaceTextPartOfText() {
		assertEquals("<x><b></b><x/><b>sdfsdf</b><x/><x/><x/></x>",
				ReplaceText.replace("<x><b></b><x>Hello world</x><b>sdfsdf</b><x>Goodmorning"
						+ "</x><x>69</x><x>sdfsdfsdf</x></x>"));
	}

	/**
	 * Tests replace function by not replacing any of the text.
	 */
	@Test
	public void testReplaceNoText() {
		assertEquals("<x</x>This te<x>t will not be <x> replaced<x/>",
				ReplaceText.replace("<x</x>This te<x>t will not be <x> replaced<x/>"));
	}
}
