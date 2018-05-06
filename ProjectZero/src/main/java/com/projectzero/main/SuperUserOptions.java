package com.projectzero.main;

import static com.projectzero.main.MenuStrings.SUPERUSER_MENU;

import java.util.List;
import java.util.Scanner;

import com.projectzero.dao.Account;
import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
import com.projectzero.exceptions.AccountException;
import com.projectzero.exceptions.UserNameException;

public class SuperUserOptions {
	static Scanner scanner = new Scanner(System.in);

	static void userEntersSuperUserMenu() {
		while(true) {
			System.out.println(SUPERUSER_MENU);
			System.out.println();
			char userKeypress = scanner.next().charAt(0);
			if (userKeypress == '0')
				break;

			switch(userKeypress) {
				case '1':
					superUserViewsAllUsers();
					break;
				case '2':
					superUserCreatesNewUser();
					break;
				case '3':
					superUserUpdatesUser();
					break;
				case '4':
					superUserDeletesUser();
					break;
				default:
					System.out.println("bad input, try again");
			}				
		}		
	}
	
	private static void superUserViewsAllUsers() {
		System.out.println("All bank users:");
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.getAllUsers();
		for(User u : list) {
			System.out.println(u.toString());
		}
	}
	
	private static void superUserCreatesNewUser() {
		while(true) {
			try {
				System.out.println("Enter user name:");
				String userName = scanner.next();
				System.out.println("Enter password:");
				String password = scanner.next();
				
				UserDAO userDao = new UserDAO();
				userDao.addUser(userName, password);
				System.out.printf("Created account with username = %s and password = %s\n", userName, password);
				System.out.println("Enter any key to continue...");
				scanner.next();
				break;
			} catch(UserNameException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void superUserUpdatesUser() {
		System.out.println("All bank users:");
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.getAllUsers();
		for(User u : list) {
			System.out.println(u.toString());
		}
		
		System.out.println("Please enter the userid of the user you want to update:");
		String userId = scanner.next();
		int intUserId = -1;
		
		try {
			intUserId = Integer.parseInt(userId);
			
			boolean found = false;
			for(User user : list) {
				if(intUserId == user.getUserId()) {
					
					System.out.println("User details: " + user.toString());
					System.out.println("Enter a new username for the user or press 0 to skip");
					String input = scanner.next();
					String newUsername = (input.equals("0")) ? user.getUserName() : input;
					
					System.out.println("Enter a new password for the user or press 0 to skip");
					input = scanner.next();
					String newPassword = (input.equals("0")) ? user.getPassword() : input;
					
					userDAO.updateUser(user.getUserId(), newUsername, newPassword);
					found = true;
					System.out.println("Successfully updated user with id " + intUserId);
				}
			}
			
			if(!found) {
				System.out.println("No user with that id exists.");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid user Id format.");
		} catch(UserNameException e) {
			System.out.println("Could not update user.");
		}
	}
	
	private static void superUserDeletesUser() {
		System.out.println("All bank users:");
		UserDAO userDAO = new UserDAO();
		List<User> list = userDAO.getAllUsers();
		for(User u : list) {
			System.out.println(u.toString());
		}
		
		System.out.println("Please enter the userid of the user you want to delete:");
		String userId = scanner.next();
		int intUserId = -1;
		
		try {
			intUserId = Integer.parseInt(userId);
			
			boolean found = false;
			for(User user : list) {
				if(intUserId == user.getUserId()) {
					userDAO.deleteUser(intUserId);
					found = true;
					System.out.println("Successfully deleted user with id " + intUserId);
				}
			}
			
			if(!found) {
				System.out.println("No user with that id exists.");
			}
		} catch(NumberFormatException e) {
			System.out.println("Invalid user Id format.");
		}
	}
}
