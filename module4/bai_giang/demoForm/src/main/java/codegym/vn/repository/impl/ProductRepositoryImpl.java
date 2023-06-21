package codegym.vn.repository.impl;

import codegym.vn.entity.Product;
import codegym.vn.repository.CategoryRepository;
import codegym.vn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean create(Product product) {
        entityManager.persist(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        entityManager.merge(product);
        return true;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public boolean deleteById(int id) {
        entityManager.remove(findById(id));
        return true;
    }

    @Override
    public List<Product> findProductByName(String name) {
        List<Product> productList = entityManager.createQuery(
                "select p from Product p where p.name like :name")
                .setParameter("name", "%" + name + "%").getResultList();
//        productList = entityManager.createNamedQuery("findProductByName")
//                .setParameter("name", name).getResultList();
        return productList;
    }

    @Override
    public List<Product> findProductByPrice(double min, double max) {
        List<Product> productList = entityManager.createQuery(
                "select p from Product p where p.price between ?1 and ?2")
                .setParameter(1, min)
                .setParameter(2, max)
                .getResultList();
        return null;
    }
}
