import java.util.Scanner;

public class UserInputService {
    Scanner loginInput = new Scanner(System.in);
    LoginService loginService;

    public UserInputService(LoginService loginService) {
        this.loginService = loginService;
    }
    public void loginInput() {
        System.out.println("Enter username");
        String userName = loginInput.nextLine();
        System.out.println("Enter password");
        String password = loginInput.nextLine();

        if (loginService.verifyUser(userName, password)) {
            System.out.println("Username and password is valid");
        }
        else {
            System.out.println("Username and password is invalid");

        }
    }
}
