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

import java.lang.reflect.Method;

/**
 * @author eprtuxy
 * @param <T>
 * 
 */
public class MyJUnitFramework {
	Object object;
	Class<?> cls;

	public MyJUnitFramework(String className) {
		try {
			cls = Class.forName(className);
			object = cls.newInstance();
		} catch (Exception e) {
			throw new MyAssertError("can't find this class");
		}
	}

	/**
	 * run all the method which is annotated by MyTest
	 */
	protected void runAllTests() {
		for (Method method : cls.getMethods()) {
			if (method.isAnnotationPresent(MyTest.class)) {
				try {
					System.out.println(method.toGenericString());
					method.invoke(object);
					System.out.println("Successful");
				} catch (Exception e) {
					System.err.println("Failed");
				}
			}
		}
	}

	/**
	 * run the set up method which is annonated by MyBeforeClass
	 */
	protected void runBeforeClass() {
		for (Method method : cls.getMethods()) {
			if (method.isAnnotationPresent(MyBeforeClass.class)) {
				try {
					System.out.println("=============running===========");
					System.out.println(method.toString());
					method.invoke(object);
				} catch (Exception e) {
					throw new MyAssertError("");
				}
			}
		}
	}

	/**
	 * run the set up method which is annonated by MyAfterClass
	 */
	protected void runAfterClass() {
		for (Method method : cls.getMethods()) {
			if (method.isAnnotationPresent(MyAfterClass.class)) {
				try {
					method.invoke(object);
					System.out.println(method.toString());
					System.out.println("=============finish===========");
				} catch (Exception e) {
					throw new MyAssertError("");
				}
			}
		}
	}

	public void runTestSuite() {
		try {
			runBeforeClass();
			runAllTests();
			runAfterClass();
		} catch (Throwable e) {
			System.err.println("Failed");
		}

	}
}
