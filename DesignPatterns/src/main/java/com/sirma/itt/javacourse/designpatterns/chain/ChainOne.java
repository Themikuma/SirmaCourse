package com.sirma.itt.javacourse.designpatterns.chain;

/**
 * The first chain of the chain of responsibility.
 * 
 * @author gdimitrov
 */
public class ChainOne extends RequestHandler {

	@Override
	public String handleRequest(String request) {
		if (request.contains("exception")) {
			return "Chain One";
		}
		return super.handleRequest(request);
	}
}
