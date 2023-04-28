package service;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IService<Product> {
    @Override
    public List<Product> findAll(String search, int index) {
        return new ArrayList<Product>();
    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public int countAllFromProduct() {
        return 0;
    }
}
