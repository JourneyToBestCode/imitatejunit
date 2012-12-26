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
package com.myjunit.sample;

import com.myjunit.MyJUnitFramework;
import com.myjunit.MyAssert;
import com.myjunit.MyBeforeClass;
import com.myjunit.MyAfterClass;
import com.myjunit.MyTest;

/**
 * @author eprtuxy
 * 
 */
public class testPeople {

	People people = new People("name1", 30);

	@MyBeforeClass
	public void beforeClass() {
		System.out.println("before class ...");
	}

	@MyAfterClass
	public void afterClass() {
		System.out.println("after class ...");
	}

	@MyTest
	public void testAge() {
		// actual age is 30
		MyAssert.myAssertEquals(10, people.getAge());
	}

	@MyTest
	public void testName() {
		MyAssert.myAssertEquals("name1", people.getName());
	}

	@MyTest
	public void testFail() {
		MyAssert.myFail();
	}

	public static void main(String[] args) {
		MyJUnitFramework test = new MyJUnitFramework(testPeople.class.getName());
		test.runTestSuite();
	}
}
