package codegym.vn.service;

import codegym.vn.entity.Product;

import java.util.List;

public interface ProductService {
    boolean create(Product product);
    boolean update(Product product);
    Product findById(int id);
    List<Product> findAll();
    boolean deleteById(int id);
    List<Product> findProductByName(String name);
    List<Product> findProductByPrice(double min, double max);
}
