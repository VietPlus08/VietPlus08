package SomeEX.MVCLogin;

public class LoginSolution {
    public static void main(String[] args) {
        LoginView loginView = new LoginView();
        LoginController loginController = new LoginController(loginView);
        loginController.login();
    }
}
