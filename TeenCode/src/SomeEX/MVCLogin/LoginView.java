package SomeEX.MVCLogin;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    public LoginModel getInforFromConsole(){
        System.out.println("Input USERNAME: ");
        String user = scanner.nextLine();
        System.out.println("Input PASSWORD: ");
        String pass = scanner.nextLine();
        return new LoginModel(user, pass);
    }
}
