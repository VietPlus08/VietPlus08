package com.example.demo.service.impl;

import com.example.demo.entities.Book;
import com.example.demo.repos.IBookRepo;
import com.example.demo.service.IBookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {

    final
    IBookRepo repo;

    public BookService(IBookRepo repo) {
        this.repo = repo;
    }

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Book findById(String id) {
        return repo.findById(id).orElse(new Book());
    }

}
