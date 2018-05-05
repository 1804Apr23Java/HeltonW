package com.projectzero.main;

import static com.projectzero.main.MenuStrings.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.projectzero.dao.Account;
import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
import com.projectzero.util.ConnectionUtil;

public class BankDriver {

static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	
		
		userEntersMainMenu();
		scanner.close();
	}	
	
	private static void userEntersMainMenu() {
		while(true) {
			System.out.println(MAIN_MENU);
			System.out.println();
			char userKeypress = scanner.next().charAt(0);
			if (userKeypress == '0')
				break;
			processMainMenuKeypress(userKeypress);
		}
		
		System.out.println(GOODBYE_USER);
	}
	
	private static void processMainMenuKeypress(char userKeypress) {
		switch(userKeypress) {
//			case '1':
//				userLogIn();
//				break;
			case '2':
				createUserAccount();
				break;
			case '9':
				adminLogIn();
				break;
			default:
				System.out.println("bad input, try again");
		}
	}

	private static void adminLogIn() {
		// ask for username and password
		// read from admin.properties
		// if yes, go to userEntersAdminMenu
		// if no, print line and go back to main menu
		
	}
	
	private static void createUserAccount() {
		System.out.println("Enter user name:");
		String userName = scanner.next();
		System.out.println("Enter password:");
		String password = scanner.next();
		
		
	}

//	private static void userLogIn() {
//		System.out.println("Enter user name:");
//		String userName = scanner.next();
//		System.out.println("Enter password:");
//		String password = scanner.next();
//		
//		/*
//		 * Needs a boolean check to see if user is found in DB
//		 * If true, enter user activities menu and pass a User
//		 * If false, break
//		 */
//		userEntersUserActivitiesMenu(currentUser);
//	}
//
//	private static void userEntersUserActivitiesMenu(User currentUser) {
//		while(true) {
//			System.out.println(USER_ACTIVITIES_MENU);
//			System.out.println();
//			char userKeypress = scanner.next().charAt(0);
//			if (userKeypress == '0')
//				break;
//			processUserActiviesKeypress(currentUser, userKeypress);
//		}
//		
//	}
//
//	private static void processUserActiviesKeypress(User currentUser, char userKeypress) {
//		switch(userKeypress) {
//		case '1':
//			//probably just call account update menu here
//			List<Account> accountList = currentUser.getUserAccounts();
//			for(Account a : accountList) {
//				System.out.println(a.toString); //Accounts need a toString() 
//			}
//			System.out.println("Press any key to continue...");
//			scanner.next();
//			break;
//		case '2':
//			String currencyString = scanner.next();
//			while(!validateCurrency(currencyString)){
//				System.out.println("Bad input!  Please enter a currency amount 'XXXX.XX', or '0' to exit.");
//				currencyString = scanner.next();
//				if(currencyString.length()==1 && currencyString.charAt(0)=='0') break;
//			}
//			AccountDAO accountDAO = new AccountDAO();
//			accountDAO.addAccount(Double.parseDouble(currencyString));
//			System.out.println("You have successfully created an account!");
//			System.out.println("Account information: " + accountDAO.getAccountByID());
//			System.out.println("Creating new account..."); //placeholder
//			scanner.next(); //placeholder
//			break;
//		case '0':
//			System.out.println("User " + currentUser.getName() + " has logged out."); //placeholder
//			scanner.next(); //placeholder
//			break;
//		default:
//			System.out.println("bad input"); //placeholder
//		}
//		
//	}
	
	private static boolean validateCurrency(String currencyString) {
		return currencyString.matches("[0-9]+\\.[0-9]{2}");
	}
}
