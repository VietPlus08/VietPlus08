package codegym.vn.service;

import codegym.vn.entity.Category;
import codegym.vn.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository repository;

    @Override
    public boolean create(Category t) {
        repository.save(t);
        return true;
    }

    @Override
    public boolean update(Category t) {
        if (repository.existsById(t.getCategoryId())) {
            repository.save(t);
            return true;
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>)repository.findAll();
    }

    @Override
    public boolean deleteById(int id) {
        repository.deleteById(id);
        return true;
    }
}
