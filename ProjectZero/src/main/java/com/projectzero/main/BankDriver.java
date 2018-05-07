package com.projectzero.main;

import static com.projectzero.main.MenuStrings.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.projectzero.dao.Account;
import com.projectzero.dao.AccountDAO;
import com.projectzero.dao.User;
import com.projectzero.dao.UserDAO;
import com.projectzero.exceptions.AccountException;
import com.projectzero.exceptions.UserNameException;
import com.projectzero.exceptions.UserNotFoundException;

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
			case '1':
				userLogIn();
				break;
			case '2':
				createUserAccount();
				break;
			case '3':
				superuserLogIn();
				break;
			default:
				System.out.println("Bad input, please try again.");
		}
	}

	private static void superuserLogIn() {
		System.out.println("Enter superuser name:");
		String superUserName = scanner.next();
		System.out.println("Enter superuser password:");
		String superUserPassword = scanner.next();
		
		Properties prop = new Properties();
		InputStream in;
		try {
			in = new FileInputStream("superuser.properties");
			prop.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String validUsername = prop.getProperty("superusername");
		String validPassword = prop.getProperty("superpassword");
		
		if(superUserName.equals(validUsername) && superUserPassword.equals(validPassword)){
			SuperUserOptions.userEntersSuperUserMenu();
		} else {
			System.out.println("Invalid superuser credentials.");
		}		
	}
	
	private static void createUserAccount() {
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

	private static void userLogIn() {
		while(true) {
			try {
				System.out.println("Enter user name:");
				String userName = scanner.next();
				System.out.println("Enter password:");
				String password = scanner.next();
				
				UserDAO userDao = new UserDAO();
				
				User user = userDao.getUser(userName);
				if(user != null && user.validatePassword(password)) {
					userEntersUserActivitiesMenu(user);
					break;
				} else {
					System.out.println("Invalid Password, please try again.");
				}
			} catch(UserNotFoundException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("Would you like to log in again?  Press 'Y' or 'N'.");
			char userKeypress = scanner.next().charAt(0);
			if(userKeypress != 'Y' && userKeypress != 'y') {
				break;
			}
		}
	}

	private static void userEntersUserActivitiesMenu(User currentUser) {
		while(true) {
			System.out.println(USER_ACTIVITIES_MENU);
			System.out.println();
			char userKeypress = scanner.next().charAt(0);
			if (userKeypress == '0')
				break;
			processUserActiviesKeypress(currentUser, userKeypress);
		}		
	}

	private static void processUserActiviesKeypress(User currentUser, char userKeypress) {
		AccountDAO accountDAO = new AccountDAO();
		switch(userKeypress) {
			case '1':
				List<Account> accountList = accountDAO.getAccounts(currentUser.getUserId());
				if(accountList.isEmpty()) {
					System.out.println("No accounts found for this user."); 
				} else {
					System.out.println("Active accounts for user " + currentUser.getUserName() + ":");
					
					int i = 1;
					for(Account account : accountList) {
						System.out.println(account.toString(i++));
					}
					System.out.println();
				}
				
				while(true) {
					System.out.println(ACCOUNT_ACCESS_MENU);
					char accountUserKeypress = scanner.next().charAt(0);
					if (accountUserKeypress == '0')
						break;
					processAccountActiviesKeypress(currentUser, accountUserKeypress);
					
					System.out.println("Would you like to perform more account actions?  Press 'Y' or 'N'.");
					accountUserKeypress = scanner.next().charAt(0);
					if(accountUserKeypress == 'Y' || accountUserKeypress == 'y') {
						continue;
					} else {
						break;
					}
				}				
				break;
			case '2':
				System.out.println("Creating account");
				double amount = getCurrency("deposit");
				if(amount < 0) {
					break;
				}
				try {
					accountDAO.addAccount(currentUser.getUserId(), amount);
					System.out.println("You have successfully created an account!");
					
					List<Account> list = accountDAO.getAccounts(currentUser.getUserId());
					Account newAccount = list.get(list.size()-1);					
					System.out.println("Account information: " + newAccount.toString());
					
					System.out.println("Press any key to continue...");
					scanner.next();
				} catch (AccountException e) {
					System.out.println(e.getMessage());
				}				
				break;
			default:
				System.out.println("Bad input...");
				System.out.println("Press any key to continue...");
				scanner.next();
		}
	}
	
	private static void processAccountActiviesKeypress(User currentUser, char accountUserKeypress) {
		AccountDAO accountDAO = new AccountDAO();
		List<Account> list;
		boolean foundAccount = false;
		int i;
		
		switch(accountUserKeypress) {		
			case '1':
				System.out.println("These are all of your accounts:");
				list = accountDAO.getAccounts(currentUser.getUserId());
				
				i = 1;
				for(Account a : list) System.out.println(a.toString(i++));
				
				while(true) {
					System.out.println("Please enter account ID of account you would like to deposit into or 0 to exit:");
					String accountID = scanner.next();
					int intAccountId = -1;
					try {
						if(accountID.equals("0")) break;
						intAccountId = Integer.parseInt(accountID);
						
						for(Account account : list) {
							if(intAccountId == account.getAccountId()) {
								foundAccount = true;
								double amount = getCurrency("deposit");
								if(amount < 0) break;
								double currBalance = account.getBalance() + amount;
								
								try {
									accountDAO.updateAccount(intAccountId, currentUser.getUserId(), currBalance);
									System.out.printf("Successfully deposited $%.2f in account %d\n", amount, intAccountId);
									System.out.printf("Current balance for account %d is $%.2f\n", account.getAccountId(), currBalance);
									
								} catch(AccountException e) {
									System.out.println("Please enter a value less than 1 trillion to deposit.");
									System.out.println(e.getMessage());
								}
								break;
							}
						}
						
						if(!foundAccount) {
							System.out.println("No account with that ID found.");
						}
					} catch(NumberFormatException e) {
						System.out.println("Invalid account id, please enter the correct id or 0 to exit");
					}
				}
				
				break;
			case '2':
				System.out.println("These are all of your accounts:");
				list = accountDAO.getAccounts(currentUser.getUserId());
				
				i = 1;
				for(Account a : list) System.out.println(a.toString(i++));
				
				while(true) {
					System.out.println("Please enter account ID of account you would like to withdraw from or 0 to exit:");
					String accountID = scanner.next();
					int intAccountId = -1;
					try {
						if(accountID.equals("0")) break;
						intAccountId = Integer.parseInt(accountID);
						
						
						for(Account account : list) {
							if(intAccountId == account.getAccountId()) {
								foundAccount = true;
								double amount = getCurrency("withdraw");
								if(amount < 0) break;
								double currBalance = account.getBalance() - amount;
								
								try {
									if(currBalance >= 0) {
										accountDAO.updateAccount(intAccountId, currentUser.getUserId(), currBalance);
										System.out.printf("Successfully withdrew $%.2f from account %d\n", amount, intAccountId);
										System.out.printf("Current balance for account %d is $%.2f\n", account.getAccountId(), currBalance);
									} else {
										System.out.println("Insufficient funds for withdrawal.");
									}
									
								} catch(AccountException e) {
									System.out.println("Please enter a value less than 1 trillion to deposit.");
								}
								break;
							}
						}
						if(!foundAccount) {
							System.out.println("No account with that ID found.");
						}
						break;
					} catch(NumberFormatException e) {
						System.out.println("Invalid account id, please enter the correct id or 0 to exit");
					}
				}
				break;
			case '3':
				System.out.println("These are all of your accounts:");
				list = accountDAO.getAccounts(currentUser.getUserId());
				
				i = 1;
				for(Account a : list) System.out.println(a.toString(i++));
				
				while(true) {
					System.out.println("You may only delete accounts with balance of 0.");
					System.out.println("Please enter account ID of account you would like to delete or 0 to exit:");
					String accountID = scanner.next();
					int intAccountId = -1;
					try {
						if(accountID.equals("0")) break;
						intAccountId = Integer.parseInt(accountID);						
						
						for(Account account : list) {
							if(intAccountId == account.getAccountId()) {
								foundAccount = true;
								if(account.getBalance() == 0) {
									accountDAO.deleteAccount(intAccountId);
									System.out.println("Account " + intAccountId + " successfully deleted.");
								} else {
									System.out.println("To delete an account, the balance must be 0.");
								}
								break;
							}
						}
						if(!foundAccount) {
							System.out.println("No account with that ID found.");
						}
						break;
					} catch(NumberFormatException e) {
						System.out.println("Invalid account id, please enter the correct id or 0 to exit");
					}
				}
				break;
			default:
		}		
	}
	
	static double getCurrency(String action) {
		System.out.println("Please enter amount you wish to " + action + " in the form 'XXXX.XX', or '0' to exit.");
		String currencyString = scanner.next();
		if(currencyString.equals("0")) return -1.0;
		
		while(!currencyString.matches("[0-9]+\\.?[0-9]{0,2}")) {
			if(currencyString.equals("0")) return -1.0;
			System.out.println("Bad input!  Please enter a currency amount 'XXXX.XX', or '0' to exit.");
			currencyString = scanner.next();			
		}
		
		return Double.parseDouble(currencyString);
	}
}
