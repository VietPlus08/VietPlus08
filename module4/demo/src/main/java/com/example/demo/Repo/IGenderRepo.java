package com.example.demo.Repo;

import com.example.demo.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Iterator;

public interface IGenderRepo extends JpaRepository<Gender,String> {
    Iterator<Gender> findAllByNameContaining(String name);

    Gender findById(int id);



}
