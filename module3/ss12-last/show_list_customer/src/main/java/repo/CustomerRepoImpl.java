package repo;

import entity.Customer;
import utils.ConnecDB;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerRepoImpl implements IRepo<Customer> {

    @Override
    public List<Customer> findAll(String index) {
        int offset = (Integer.parseInt(index) - 1) * 5;
        String selectAll = "select * from customer limit ?, 5";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(selectAll)) {
            statement.setInt(1,offset);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String point = rs.getString("point");
                String img = rs.getString("img");
                customers.add(new Customer(id, name, age, point, img));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public void save(Customer e) {
        String addNew = "insert into customer value (?,?,?,?,?)";
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(addNew)) {
            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setString(3, e.getAge());
            statement.setString(4, e.getPoint());
            statement.setString(5, e.getImg());
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByIdOrName(String searchId, String searchName, String index) {
        int offset = (Integer.parseInt(index) - 1) * 5;
        String selectAll = "select * from customer where id like concat('%',?,'%') and name like concat('%',?,'%') limit ?, 5";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = ConnecDB.getConnect();
            PreparedStatement statement = connection.prepareStatement(selectAll)) {
            statement.setString(1, searchId);
            statement.setString(2, searchName);
            statement.setInt(3, offset);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String point = rs.getString("point");
                String img = rs.getString("img");
                customers.add(new Customer(id, name, age, point, img));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        String findById = "select * from customer where id = ?";
        Customer customer = null;
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(findById)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String age = rs.getString("age");
                String point = rs.getString("point");
                String img = rs.getString("img");
                customer = new Customer(id, name, age, point, img);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = false;
        String deleteCustomer = "delete from customer where id = ?";
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(deleteCustomer)) {
            statement.setInt(1, id);
            int res = statement.executeUpdate();
            rowDeleted = res > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean update(Customer customer) {
        boolean rowDeleted = false;
        String updateCustomer = "update customer set name = ?, age = ?, point =?, img = ? where id = ?";
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(updateCustomer)) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAge());
            statement.setString(3, customer.getPoint());
            statement.setString(4, customer.getImg());
            statement.setInt(5, customer.getId());
            int res = statement.executeUpdate();
            rowDeleted = res > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public int countItem() {
        int items = 0;
        String countItem = "select count(*) from customer;";
        try (Connection connection = ConnecDB.getConnect();
             PreparedStatement statement = connection.prepareStatement(countItem)) {
            ResultSet rs = statement.executeQuery();
            rs.next();
            items = rs.getInt(1);
            int res = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return items;
    }
}
