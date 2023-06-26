package com.java.repo;

import com.java.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepo extends JpaRepository<Comment, Integer> {



}
