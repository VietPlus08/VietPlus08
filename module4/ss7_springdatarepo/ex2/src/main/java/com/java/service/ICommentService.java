package com.java.service;

import com.java.entity.Comment;
import com.java.entity.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICommentService {

    void save(CommentDto commentDto);

    Comment findById(Integer id);

    List<Comment> findAll();

}
