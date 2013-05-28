package com.sirma.itt.javacourse.designpatterns.chain;

/**
 * The second chain of the chain of responsibility.
 * 
 * @author gdimitrov
 */
public class ChainTwo extends RequestHandler {
	@Override
	public String handleRequest(String request) {
		if (request.contains("error")) {
			return "Chain Two";
		}
		return super.handleRequest(request);
	}
}
