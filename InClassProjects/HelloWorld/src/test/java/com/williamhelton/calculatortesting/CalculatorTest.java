package test.java.com.williamhelton.calculatortesting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.com.williamhelton.calculatortesting.Calculator;

public class CalculatorTest {
	
	/*
	 * Requirement: build a String calculator with a method which can
	 * add a comma separated list of 0, 1, or 2 numbers
	 */
	
	public Calculator c;
	
	@Before
	public void setCalc() {
		this.c = new Calculator();
	}
	
	@Test
	public void testEmptyStringReturnZero() {
		Calculator c = new Calculator();
		double sum = c.add("");
		assertEquals(0, sum, .001);
	}
	
	@Test
	public void twoNumbersReturnsSum() {
		Calculator c = new Calculator(); 
		double sum = c.add("12.9,15.3");
		assertEquals(28.2, sum, .001);
	}
}
