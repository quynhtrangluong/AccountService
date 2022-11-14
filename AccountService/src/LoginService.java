import java.util.ArrayList;

public class LoginService {
	private CustomerService customerService;

	public LoginService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public boolean verifyUser(final String username,final String password) {
		ArrayList<User> database = customerService.getUserList();

		for (User user : database) {
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
