package utils;

import java.sql.*;

public class ConnectDB {
    public static Connection getConnect(){
        String port = "jdbc:mysql://localhost:3306/product_management";
        String user = "root";
        String pass = "anhquang0812@";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(port,user,pass);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
}
