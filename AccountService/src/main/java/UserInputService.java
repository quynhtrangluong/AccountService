import java.util.ArrayList;
import java.util.Scanner;

public class UserInputService {
	 private Scanner userInput = new Scanner(System.in);
	 private LoginService loginService;
	 private CustomerService customerService;

	public UserInputService(final LoginService loginService, final CustomerService customerService) {
		this.loginService = loginService;
		this.customerService = customerService;
	}

	public User loginInput() {
		System.out.println("Enter username");
		String userName = userInput.nextLine();
		System.out.println("Enter password");
		String password = userInput.nextLine();

		if (loginService.verifyUser(userName, password)) {
			System.out.println("Username and password is valid");
		} else {
			System.out.println("Username and password is invalid");
		}

		for (User user : customerService.getUserList()){
			if (userName.equals(user.getUserName())) {
				return user;
			}
		}
		return null;
	}

	public User createAccountInput() {
		ArrayList<User> newUserDatabase = customerService.getUserList();

		boolean isNewUsernamePasswordValid = false;
		String newUsername;
		String newPassword;
		do {
			System.out.println("Enter username: ");
			newUsername = userInput.nextLine();
			System.out.println("Enter password: ");
			newPassword = userInput.nextLine();
			System.out.println("Enter password again: ");
			String newPasswordCheck = userInput.nextLine();

			boolean isUsernameValid = true;
			for (User user : newUserDatabase) {
				if (newUsername.equals(user.getUserName())) {
					System.out.println("Username is used. Please try another one.");
					isUsernameValid = false;
				}
			}

			boolean isPasswordValid = true;
			if (!newPasswordCheck.equals(newPassword)) {
				System.out.println("Password does not match");
				isPasswordValid = false;
			}


			isNewUsernamePasswordValid = isUsernameValid && isPasswordValid;
		}
		while (!isNewUsernamePasswordValid);

		User newUser = new User(newUsername, newPassword, false);
		customerService.addUser(newUser);
		System.out.println("Account successfully created !!!");
		return newUser;
	}


	public void mainUserInputFlow() {
		System.out.println("Hello welcome to Account Service");
		System.out.println("Have you got an account? (YES/NO) ");
		String isAccountExist = userInput.nextLine();

		User currentUser;
		if (isAccountExist.equals("YES")) {
			currentUser = loginInput();
		} else {
			currentUser = createAccountInput();
		}
		customerActionInput(currentUser);
	}
	public void customerActionInput(User user){
		System.out.println("What's action do you want to do now");
		if(user.getAdmin() == true){
			System.out.println("1. Print all customer's information");
			System.out.println("2. Delete customer's information");
			System.out.println("3. Print selected customer details");
			System.out.println("Please choose a number for the action you want");
			String adminSelectOption = userInput.nextLine();
			switch (adminSelectOption){
				case "1":
					customerService.printAllCustomersInfo();
					break;
				case "2":
					System.out.println("Please choose customer you want to delete");
					System.out.println("Customer name: ");
					String deleteCustomer = userInput.nextLine();
					if(loginService.verifyUsername(deleteCustomer)){
						loginService.deleteSelectCustomerInfo(deleteCustomer);
					}
					else {
						System.out.println("Account name does not exist");
					}
					break;
				case "3":
					System.out.println("PLease choose customer you want to print out");
					String printCustomer = userInput.nextLine();
					if(loginService.verifyUsername(printCustomer)){
						loginService.printSelectCustomerInfo(printCustomer);
					}
					break;
			}
		}
		else{
			System.out.println("1. Print your information");
			System.out.println("2. Delete your information");
			System.out.println("Please choose a number for the action you want");
			String customerSelectOption;
			customerSelectOption = userInput.nextLine();
			switch (customerSelectOption) {
				case "1":
					loginService.printSelectCustomerInfo(user.getUserName());
					break;
				case "2":
					loginService.deleteSelectCustomerInfo(user.getUserName());
					break;
			}
		}

	}
}
