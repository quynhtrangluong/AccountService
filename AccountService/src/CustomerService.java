import java.util.ArrayList;

public class CustomerService {
    ArrayList<User> userList = new ArrayList<>();

    public void createData() {
        User user1 = new User();
        user1.setPassword("123");
        user1.setUserName("TrangLuong");
        user1.setAdmin(true);

        User user2 = new User();
        user2.setPassword("234");
        user2.setUserName("BinhDao");
        user2.setAdmin(false);

        User user3 = new User();
        user3.setPassword("345");
        user3.setUserName("Ahihi");
        user3.setAdmin(false);

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public void addUser(User user) {
        userList.add(user);
    }
}

