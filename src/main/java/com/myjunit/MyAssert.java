/* 
 * Created : Nov 19, 2012 
 * 
 * Copyright (c) 2012 Ericsson AB, Sweden. 
 * All rights reserved. 
 * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.myjunit;

/**
 * @author eprtuxy
 * 
 */
public class MyAssert {
	/**
	 * Assert the condition is true
	 * 
	 * @param condition
	 */
	public static void myAssertTrue(Boolean condition) {
		if (!condition) {
			System.err.println("Excepted: true");
			System.err.println("Actual: false");
			myFail();
		}
	}

	/**
	 * assert whether these two object is equal
	 * 
	 * @param expected
	 * @param actual
	 */
	public static void myAssertEquals(Object expected, Object actual) {
		if (!(expected != null && expected.equals(actual))) {
			System.err.println("Excepted: " + expected);
			System.err.println("Actual: " + actual);
			myFail();
		}
	}

	/**
	 * fail the test case
	 */
	public static void myFail() {
		throw new MyAssertError();
	}
}
