package codegym.vn.service;

import codegym.vn.entity.Product;
import codegym.vn.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository repository;
    @Override
    public boolean create(Product product) {
        repository.save(product);
        return false;
    }

    @Override
    public boolean update(Product product) {
        if (repository.existsById(product.getId())) {
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> findProductByName(String name) {
        return repository.findAllByNameContaining(name);
    }

    @Override
    public List<Product> findProductByPrice(double min, double max) {
        return null;
    }
}
