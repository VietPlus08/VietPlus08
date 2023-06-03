package com.java.repo;

import com.java.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1, "Nokia","5","5000000","Old phone"));
        productList.add(new Product(2, "IPhone 12","15","15000000","Old phone"));
        productList.add(new Product(3, "IPhone 14","25","25000000","New phone"));
        productList.add(new Product(4, "SS Galaxy","15","15000000","New phone"));
    }

    public List<Product> findAll(){
        return productList;
    }

    public void addNew(Product product){
        productList.add(product);
    }

    public void update(Product product){
        Product findProduct = findById(product.getId());
        if (findProduct != null){
            productList.remove(findById(product.getId()));
        }
        productList.add(product);
    }

    public Product findById(int id){
        return productList.stream().filter(i -> i.getId() == id).findFirst().orElse(null);
    }

    public void delete(int id){
        productList.remove(findById(id));
    }



}
