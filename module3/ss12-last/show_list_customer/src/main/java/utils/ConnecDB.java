package utils;

import java.sql.*;

public class ConnecDB {
    public static Connection getConnect(){
        String port = "jdbc:mysql://localhost:3306/quanlysinhvien";
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
