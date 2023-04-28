package entity;

public class Account {
    String user, password;

    public Account(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Account() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
