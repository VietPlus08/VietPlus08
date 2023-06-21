package com.java.service;

import com.java.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICommentService {

    void save(Comment comment);

    Comment findById(Integer id);

    List<Comment> findAll();

}
