import java.util.ArrayList;

public class LoginService {
	CustomerService customerService;

	public LoginService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public boolean verifyUser(String username, String password) {
		ArrayList<User> database = customerService.userList;
		customerService.createData();

		for (User user : database) {
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}
}
