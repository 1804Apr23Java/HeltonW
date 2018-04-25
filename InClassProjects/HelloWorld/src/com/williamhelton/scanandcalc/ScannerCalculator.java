package com.williamhelton.scanandcalc;

import java.util.Scanner;

/*
 * This class holds the logic for the calculator.
 */
public class ScannerCalculator {
	
	/*
	 * This is a string validation method that checks for valid digit integers.
	 */
	public static boolean checkString(String str) throws CalculatorException {
		//check for negative num
		int i = 0;
		if(str.charAt(i) == '-') {
			i++;
		}
		
		for(; i < str.length(); i++) {
			char a = str.charAt(i);
			if(a < 48 || a > 57) {
				throw new CalculatorException("Invalid number at index " + i);
			}
		}
		return true;
	}
	
	/*
	 * This is the entry point for the calculator.  It reads data from the user
	 * in preparation for calculation and finally calls the calculation method.
	 */
	public static void readFromUser(){
		Scanner sc = new Scanner(System.in);
		Integer num1;
		Integer num2;
		char operator;
		
		while(true) {
			try {
				System.out.println("Enter first number: ");
				String temp = sc.next();
				checkString(temp);
				num1 = new Integer(temp);
				break;
			} catch(CalculatorException e) {
				System.out.println("Please enter a valid number.");
			} catch(NumberFormatException e) {
				System.out.println("Number out of range!  Cannot calculate.");
			}
		}
		
		while(true) {
			System.out.println("Enter the operator: ");
			operator = sc.next().charAt(0);
			if(operator == '+' || operator == '-' || operator == '*' || operator == '/') {
				break;
			} else {
				System.out.println("Please enter a valid operator.");
			}
		} 
		
		while(true) {
			try {
				System.out.println("Enter second number: ");
				String temp = sc.next();
				checkString(temp);
				num2 = new Integer(temp);
				break;
			} catch(CalculatorException e) {
				System.out.println("Please enter a valid number.");
			} catch(NumberFormatException e) {
				System.out.println("Number out of range!  Cannot calculate.");
			}
		}		

		calculateOperation(num1, num2, operator);
	}
	
	/*
	 * This method holds the logic for calculations once all the data is collected.
	 */
	public static void calculateOperation(int num1, int num2, char operator){
		long result;
		switch(operator) {
			case '+':
				result = (long)num1 + (long)num2;
				System.out.println(result);
				break;
			case '-':
				result = (long)num1 - (long)num2;
				System.out.println(result);
				break;
			case '*':
				result = (long)num1 * (long)num2;
				System.out.println(result);
				break;
			case '/':
				if(num2 == 0) {
					System.out.println("Cannot divide by zero!");
					break;
				}
				System.out.println(num1/num2);
				break;
		}
	}
}
