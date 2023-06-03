package com.java.service;

import com.java.entity.Product;
import com.java.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

//    public ProductService(ProductRepository repository) {
//        this.repository = repository;
//    }
//
//    public ProductService() {
//
//    }


    public List<Product> findAll(){
        return repository.findAll();
    }

    public void addNew(Product product){
        repository.addNew(product);
    }

    public void update(Product product){
        repository.update(product);
    }

    public void delete(int id){
        repository.delete(id);
    }

    public Product findById(int id){
        return repository.findById(id);
    }
}
