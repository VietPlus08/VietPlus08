package com.java.service;

import com.java.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICommentService {

    void save(Comment comment);

    Comment findById(Integer id);

    List<Comment> findAll();

    public Page<Comment> findAllWithPages(Pageable pageable);

}
