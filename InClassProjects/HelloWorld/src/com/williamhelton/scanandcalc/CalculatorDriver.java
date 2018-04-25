package com.williamhelton.scanandcalc;

import java.util.Scanner;

/*
 * This is a driver class to start the calculator.
 * The class is in an endless while loop that asks for repeated calculations by the user.
 */
public class CalculatorDriver {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		char calculateAgain;
		do {
			ScannerCalculator.readFromUser();
			System.out.println("Calculate again?  Press \"Y\" to continue, \"N\" to quit");
			calculateAgain = sc.next().charAt(0);
		} while(calculateAgain == 'y' || calculateAgain == 'Y');
		System.out.println("Thanks for using our calculator!");
	}
}