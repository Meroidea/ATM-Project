package JavaProjects;

import java.util.Scanner;

public class JavaProjects {

	public static void main(String[] args) {
		System.out.println("Welcome to Sujan ATM\n");

		Scanner sc = new Scanner(System.in);

		// Account details
		double accountNumber = 123456;
		int pinCode = 0000;
		double accountBalance = 500;

		int attempts = 0;

		while (attempts < 3) {
			System.out.print("Enter your bank account number: ");
			double userAccountNumber = sc.nextDouble();

			System.out.print("Enter your security PIN code: ");
			int userPinCode = sc.nextInt();

			if (userAccountNumber == accountNumber && userPinCode == pinCode) {
				performAccountAction(sc, accountBalance);
				break;
			} else {
				attempts++;
				System.out.println("\nIncorrect account number or PIN code\n");
			}
		}

		if (attempts == 3) {
			System.out.println("Maximum attempts reached. Please try again later.");
		}
	}

	public static void performAccountAction(Scanner sc, double accountBalance) {
		int userAction;
		do {
			accountAction();
			System.out.print("Enter your choice: ");
			userAction = sc.nextInt();

			switch (userAction) {
			case 1:
				System.out.println("Your current account balance is: $" + accountBalance);
				break;

			case 2:
				System.out.print("Enter amount to deposit: $");
				double depositAmount = sc.nextDouble();
				accountBalance += depositAmount;
				System.out.println("Deposit successful. Your updated balance is: $" + accountBalance);
				break;

			case 3:
				System.out.print("Enter amount to withdraw: $");
				double withdrawAmount = sc.nextDouble();
				if (withdrawAmount > accountBalance) {
					System.out.println("Sorry ! Insufficient funds.");
				} else {
					accountBalance -= withdrawAmount;
					System.out.println("Withdrawal successful. Your new balance is: $" + accountBalance);
				}
				break;

			case 4:
				System.out.println("Thank you for using Commonwealth Bank ATM!");
				break;

			default:
				System.out.println("Invalid selection.");
				break;
			}
			if (userAction != 4) {
				System.out.println("Do you want to perform another action? (yes/no): ");
				String choice = sc.next();
				if (choice.equalsIgnoreCase("no")) {

					System.out.print("\nThank you for using Sujan ATM. See you next time !");
					return;
				}
			}

		} while (userAction != 4);
	}

	public static void accountAction() {
		System.out.println("\nPlease select from the following options:\n" + "1. Check Account Balance\n"
				+ "2. Deposit\n" + "3. Withdraw\n" + "4. Exit");
	}
}



