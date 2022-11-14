import java.util.ArrayList;

public class CustomerService {
	private ArrayList<User> userList = new ArrayList<>();
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}

	public void createData() {
		User user1 = new User("TrangLuong","123",true);

		User user2 = new User("BinhDao", "234",false);

		User user3 = new User("Ahihi", "345",false);

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}

	public void addUser(User user) {
		userList.add(user);
	}
}

