package com.sirma.itt.javacourse.designpatterns;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sirma.itt.javacourse.designpatterns.chain.ChainTwo;
import com.sirma.itt.javacourse.designpatterns.chain.SubchainOneOne;
import com.sirma.itt.javacourse.designpatterns.chain.SubchainOneTwo;

/**
 * Tests on the chain of responsibility pattern.
 * 
 * @author gdimitrov
 */
public class ChainOfResponsibilityTest {

	/**
	 * Test the handleRequest function by giving a request that should be handled by RequestHandler.
	 */
	@Test
	public void testHandleRequestByRequstHandler() {
		SubchainOneTwo handler = new SubchainOneTwo();
		String handledRequest = handler.handleRequest("something something darkside");
		assertEquals("Request Handler", handledRequest);
	}

	/**
	 * Test the handleRequest function by giving a request that should be handled by ChainOne.
	 */
	@Test
	public void testHandleRequestByChainOne() {
		SubchainOneTwo handler = new SubchainOneTwo();
		String handledRequest = handler.handleRequest("this an exception");
		assertEquals("Chain One", handledRequest);
	}

	/**
	 * Test the handleRequest function by giving a request that should be handled by Chain Two.
	 */
	@Test
	public void testHandleRequestByChainTwo() {
		ChainTwo handler = new ChainTwo();
		String handledRequest = handler.handleRequest("this an error");
		assertEquals("Chain Two", handledRequest);
	}

	/**
	 * Test the handleRequest function by giving a request that should be handled by Subchain One
	 * One.
	 */
	@Test
	public void testHandleRequestBySubchainOneOne() {
		SubchainOneOne handler = new SubchainOneOne();
		String handledRequest = handler.handleRequest("this an unchecked thing");
		assertEquals("Subchain One One", handledRequest);
	}

	/**
	 * Test the handleRequest function by giving a request that should be handled by Subchain One
	 * Two.
	 */
	@Test
	public void testHandleRequestBySubchainOneTwo() {
		SubchainOneTwo handler = new SubchainOneTwo();
		String handledRequest = handler.handleRequest("this a checked thing");
		assertEquals("Subchain One Two", handledRequest);
	}
}
