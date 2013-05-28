package com.sirma.itt.javacourse.designpatterns.chain;

/**
 * The parent class for all the classes in the chain.
 * 
 * @author gdimitrov
 */
public class RequestHandler {

	/**
	 * This operation handles the incoming request.
	 * 
	 * @param request
	 *            - the request to handle.
	 * @return the class that handled the request.
	 */
	public String handleRequest(String request) {
		return "Request Handler";
	}
}
