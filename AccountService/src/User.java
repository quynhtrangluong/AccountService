public class User {
    private int customerId;
    private String userName;
    private String password;
    private boolean admin;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String newUsername){
       this.userName = newUsername;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String newPassword){
        this.password = newPassword;
    }
    public boolean getAdmin(){
        return admin;
    }
    public void setAdmin(boolean newAdmin){
        this.admin = newAdmin;
    }
}