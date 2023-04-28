package repos;

import entities.Category;
import entities.Product;
import utils.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepoImpl{

    public List<Category> findAll() {
        String findAll = "select * from category;";
        List<Category> list = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findAll)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                list.add(new Category(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
