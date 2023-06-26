package com.example.demo.service;

import com.example.demo.entities.Book;

import java.util.List;

public interface IBookService {

    List<Book> findAll();

    Book findById(String id);
}
