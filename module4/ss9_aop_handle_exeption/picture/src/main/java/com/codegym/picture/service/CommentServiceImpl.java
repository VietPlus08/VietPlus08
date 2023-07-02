package com.codegym.picture.service;

import com.codegym.picture.entity.Comment;
import com.codegym.picture.repo.CommentRepo;
import org.apache.tomcat.jni.Time;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    final CommentRepo repo;

    public CommentServiceImpl(CommentRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<Comment> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<Comment> findAllWithPages(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void save(Comment comment) {
        if(comment.getId() == null){
            comment.setTimeOfCreateComment(new Timestamp((new Date()).getTime()));
        }
        repo.save(comment);
    }
}
