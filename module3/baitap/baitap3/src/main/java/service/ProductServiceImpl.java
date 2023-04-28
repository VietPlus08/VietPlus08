package service;

import entities.Product;
import repos.IRepos;
import repos.ProductRepoImpl;

import java.util.List;

public class ProductServiceImpl implements IService<Product> {
    private IRepos<Product> repos = new ProductRepoImpl();

    @Override
    public List<Product> findAll(String searchName, String index) {
        return repos.findAll(searchName, index);
    }

    @Override
    public Product findById(int id) {
        return repos.findById(id);
    }

    @Override
    public boolean delete(int id) {
        return repos.delete(id);
    }

    @Override
    public void save(Product product) {
        if (findById(product.getId()) == null){
            repos.create(product);
            return;
        }
        repos.update(product);
    }

    @Override
    public int pages() {
        double items = repos.countItem();
        return (int) Math.ceil(items / 5);
    }
}
