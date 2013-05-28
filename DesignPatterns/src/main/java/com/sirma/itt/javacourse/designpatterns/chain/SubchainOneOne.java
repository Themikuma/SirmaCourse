package com.sirma.itt.javacourse.designpatterns.chain;

/**
 * The first sub chain of the first chain.
 * 
 * @author gdimitrov
 */
public class SubchainOneOne extends ChainOne {
	@Override
	public String handleRequest(String request) {
		if (request.contains("unchecked")) {
			return "Subchain One One";
		}
		return super.handleRequest(request);
	}
}
