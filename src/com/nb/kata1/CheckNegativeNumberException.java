package com.nb.kata1;


public class CheckNegativeNumberException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	CheckNegativeNumberException(String s) {
		super(s);
		System.out.printf(s);
		
		
	}

}
