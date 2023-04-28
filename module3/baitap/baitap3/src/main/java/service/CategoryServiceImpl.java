package service;

import entities.Category;
import repos.CategoryRepoImpl;

import java.util.List;

public class CategoryServiceImpl {

    private CategoryRepoImpl repo = new CategoryRepoImpl();

    public List<Category> findAll(){
        return repo.findAll();
    }

}
