public class UserAccount {
    private UID UserId;
    private String Email; 
    private String Name; 
    private String Password;

    public UserAccount(UID userId, String userName, String email, String password) {
        this.UserId = userId;
        this.Name = Name;
        this.Email = email;
        this.Password = password;
    }

    // Getters 
    private UID getUserId() {
        return UserId;
    }
    private String getEmail() {
        return Email;
    }
    private String getName() {
        return Name;
    }
    private String getPassword() {
        return Password;
    }

    // Setters
    private void setUserId(UID userId) {
        this.UserId = userId;
    }
    private void setEmail(String email) {
        this.Email = email;
    }
    private void setName(String name) {
        this.Name = name;
    }
    private void setPassword(String password) {
        this.Password = password;
    }

}
