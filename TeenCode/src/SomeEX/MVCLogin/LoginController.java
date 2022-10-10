package SomeEX.MVCLogin;

public class LoginController {
    LoginView loginView;
    public LoginController(LoginView loginView){
        this.loginView = loginView;
    }
    public void login(){
        while (true){
            LoginModel loginModel = loginView.getInforFromConsole();
            if (loginModel.getUser().equals("anhquang") &&
                loginModel.getPass().equals("123456")){
                System.out.println("Login success");
                break;
            } else {
                System.out.println("Wrong user or pass");
            }
        }
    }
}
