public class Main {
	public static void main(String[] args) {
		CustomerService customerService = new CustomerService();
		LoginService loginService = new LoginService(customerService);
		UserInputService userInputService = new UserInputService(loginService, customerService);
		userInputService.mainUserInputFlow();
	}
}