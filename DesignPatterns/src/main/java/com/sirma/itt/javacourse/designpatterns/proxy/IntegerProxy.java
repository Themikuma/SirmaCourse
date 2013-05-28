package com.sirma.itt.javacourse.designpatterns.proxy;


/**
 * The proxy class.
 * 
 * @author gdimitrov
 */
public class IntegerProxy implements ProxyPattern {

	/**
	 * When this method is called it instantiates the actual class and makes it do the work. This is
	 * done because the actual class takes a long time to create and takes up a lot of memory.
	 */
	public void doWork() {
		Proxy actualClass = IntegerFactory.createInstance();
		actualClass.doWork();
	}

}
