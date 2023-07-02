package com.codegym.picture.service;

import com.codegym.picture.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {

    List<Comment> findAll();

    Page<Comment> findAllWithPages(Pageable pageable);

    void save(Comment comment);


}
