package com.codegym.blog.repo;


import com.codegym.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog, Integer> {


}
