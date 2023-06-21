package com.java.repo;

import com.java.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepo extends JpaRepository<Blog, Integer> {



}
