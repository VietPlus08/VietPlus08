package com.java.service;

import com.java.entity.Blog;
import com.java.repo.IBlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    final IBlogRepo repo;

    public BlogServiceImpl(IBlogRepo repo) {
        this.repo = repo;
    }

    @Override
    public void save(Blog blog) {
        repo.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return repo.findAll();
    }
}
