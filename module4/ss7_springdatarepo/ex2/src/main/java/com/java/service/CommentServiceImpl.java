package com.java.service;

import com.java.entity.Comment;
import com.java.entity.CommentDto;
import com.java.repo.ICommentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService{

    final ICommentRepo repo;

//    public CommentServiceImpl(ICommentRepo repo) {
//        this.repo = repo;
//    }

    @Override
    public void save(Comment comment) {
        repo.save(comment);
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

    @Override
    public Page<Comment> findAllWithPages(Pageable pageable){
        return repo.findAll(pageable);
    }
}
