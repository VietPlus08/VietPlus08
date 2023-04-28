package repos;

import entities.Product;
import utils.ConnectDB;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProductRepoImpl implements IRepos<Product> {
    @Override
    public List<Product> findAll(String searchName, String index) {
        String findAll = "select * from product where name like concat('%',?,'%') limit ?, 5;";
        int offset = (Integer.parseInt(index) - 1) * 5;
        List<Product> productList = new ArrayList<>();
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findAll)) {
            statement.setString(1, searchName);
            statement.setInt(2, offset);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                productList.add(new Product(id, name, price, quantity, color, description, categoryId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        String findById = "select * from product where id = ?;";
        Product product = null;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findById)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                product = new Product(id, name, price, quantity, color, description, categoryId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean delete(int id) {
        String delete = "delete from product where id = ?";
        boolean rowDelete = false;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(delete)) {
            statement.setInt(1, id);
            rowDelete = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public void create(Product product) {
        String createProduct = "insert into product(`name`,price,quantity,color,`description`,categoryId) value(?,?,?,?,?,?);";
        boolean rowDelete = false;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(createProduct)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            int res = statement.executeUpdate();
            rowDelete = res > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        String updateProduct = "update product set `name` = ?, price = ?, quantity = ?, color = ?, `description` = ?, categoryId = ? where id = ?;";
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(updateProduct)) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getPrice());
            statement.setString(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setString(5, product.getDescription());
            statement.setInt(6, product.getCategoryId());
            statement.setInt(7, product.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public int countItem() {
        String countItem = "select count(*) from product;";
        int items = 0;
        try (Connection connection = ConnectDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(countItem)) {
             ResultSet rs = statement.executeQuery();
             rs.next();
             items = rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }
}
