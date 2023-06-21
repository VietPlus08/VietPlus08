package com.java.service;

import com.java.entity.Blog;

import java.util.List;


public interface IBlogService {

    void save(Blog blog);

    Blog findById(Integer id);

    List<Blog> findAll();

}
