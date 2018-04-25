package com.williamhelton.scanandcalc;

/*
 * This exception is thrown when a calculator input string appears invalid.
 */
public class CalculatorException extends Exception {
	public CalculatorException(String msg) {
		super(msg);
	}
}
