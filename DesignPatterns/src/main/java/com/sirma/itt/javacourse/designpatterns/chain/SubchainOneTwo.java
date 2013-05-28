package com.sirma.itt.javacourse.designpatterns.chain;

/**
 * The second sub chain of the first chain.
 * 
 * @author gdimitrov
 */
public class SubchainOneTwo extends ChainOne {
	@Override
	public String handleRequest(String request) {
		if (request.contains("checked")) {
			return "Subchain One Two";
		}
		return super.handleRequest(request);
	}
}
