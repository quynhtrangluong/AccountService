public class User {
	private final String userName;
	private final String password;
	private final boolean admin;

	public User(String userName,String password, boolean admin){
		this.userName = userName;
		this.password = password;
		this.admin = admin;
	}


	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public boolean getAdmin() {
		return admin;
	}

}