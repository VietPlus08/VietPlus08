package codegym.vn.repository;

import codegym.vn.entity.Product;

import java.util.List;

public interface ProductRepository extends Repository<Product> {
    List<Product> findProductByName(String name);
    List<Product> findProductByPrice(double min, double max);
}
