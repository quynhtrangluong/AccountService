import java.util.ArrayList;

public class LoginService {
	private CustomerService customerService;

	public LoginService(final CustomerService customerService) {
		this.customerService = customerService;
	}

	public boolean verifyUser(final String username, final String password) {
		ArrayList<User> database = customerService.getUserList();

		for (User user : database) {
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				return true;
			}
		}
		return false;
	}

	public boolean verifyUsername(final String username) {
		ArrayList<User> database = customerService.getUserList();
		for (User user : database) {
			if (username.equals(user.getUserName())) {
				return true;
			}
		}
		return false;
	}

	public void printSelectCustomerInfo(String username) {
		ArrayList<User> database = customerService.getUserList();
		for (User user : database) {
			if (username.equals(user.getUserName())) {
				System.out.println("Customer name: " + user.getUserName());
				System.out.println("Customer password: " + user.getPassword());
				System.out.println("Customer admin:" + user.getAdmin());
			}

		}
	}

	public void deleteSelectCustomerInfo(String username) {
		ArrayList<User> database = customerService.getUserList();
		User userToRemove = null;
		for (User user : database) {
			if (username.equals(user.getUserName())) {
				userToRemove = user;
			}
		}
		database.remove(userToRemove);
		System.out.println("Successfully deleted user: " + userToRemove.getUserName());
	}
}