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
	public void printAllCustomersInfo() {
		for (int i=0; i<userList.size(); i++) {
			User currentUser = userList.get(i);
			System.out.println("Name: " + currentUser.getUserName());
			System.out.println("admin: " + currentUser.getAdmin());
			System.out.println("password: " + currentUser.getPassword());
			System.out.println("-----------");
			}
		}

	}

