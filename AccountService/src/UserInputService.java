import java.util.ArrayList;
import java.util.Scanner;

public class UserInputService {
    Scanner userInput = new Scanner(System.in);
    LoginService loginService;
    CustomerService customerService;

    public UserInputService(LoginService loginService, CustomerService customerService) {
        this.loginService = loginService;
        this.customerService = customerService;
    }
    public void loginInput() {
        System.out.println("Enter username");
        String userName = userInput.nextLine();
        System.out.println("Enter password");
        String password = userInput.nextLine();

        if (loginService.verifyUser(userName, password)) {
            System.out.println("Username and password is valid");
        }
        else {
            System.out.println("Username and password is invalid");

        }
    }

    public void createAccountInput() {
        ArrayList<User> newUserDatabase = customerService.userList;
        customerService.createData();

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

        User newUser = new User();
        newUser.setUserName(newUsername);
        newUser.setPassword(newPassword);
        newUser.setAdmin(false);
        customerService.addUser(newUser);
        System.out.println("Account successfully created !!!");

    }


    public void mainUserInputFlow() {
        System.out.println("Hello welcome to Account Service");
        System.out.println("Have you got an account? (YES/NO) ");
        String isAccountExist = userInput.nextLine();

        if (isAccountExist.equals("YES")) {
            loginInput();
        }
        else {
            createAccountInput();
        }
    }
}
