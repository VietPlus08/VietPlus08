package com.example.demo.service;

import com.example.demo.dto.BorrowingDto;
import com.example.demo.entities.Book;
import com.example.demo.entities.Borrow;

import java.util.List;

public interface IBorrowService {

    List<Borrow> findAll();

    List<Borrow> findAllByStatus();

    void save(Borrow borrow, String bookName);

    void saveDto(BorrowingDto borrowingDto);

    void returnBook(String bookId);

    String getIdAuto();

    List<String> findAllId();

    List<BorrowingDto> findAllBorrowing();
}
