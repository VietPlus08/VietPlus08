package com.codegym.blog.service;

import com.codegym.blog.entity.Blog;
import com.codegym.blog.entity.BlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBlogService {

    void save(Blog blog);

    Blog findById(Integer id);

    List<BlogDto> findAll();

    void delete(Integer id);

    Page<Blog> findWithPage(Pageable pageable);

}
