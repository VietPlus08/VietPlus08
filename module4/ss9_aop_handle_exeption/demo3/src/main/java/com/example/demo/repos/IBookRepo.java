package com.example.demo.repos;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book, String> {

}
