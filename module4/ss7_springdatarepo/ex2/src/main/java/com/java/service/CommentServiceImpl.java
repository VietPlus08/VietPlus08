package com.java.service;

import com.java.entity.Comment;
import com.java.entity.CommentDto;
import com.java.repo.ICommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService{

    final ICommentRepo repo;

    public CommentServiceImpl(ICommentRepo repo) {
        this.repo = repo;
    }

    @Override
    public void save(CommentDto commentDto) {
        repo.save(new Comment(commentDto));
    }

    @Override
    public Comment findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Comment> findAll() {
        return repo.findAll();
    }


    public List<CommentDto> findAllDto() {
        return null;
    }
}
