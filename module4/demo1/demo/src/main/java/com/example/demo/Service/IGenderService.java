package com.example.demo.Service;

import com.example.demo.models.Gender;

import java.util.List;

public interface IGenderService {
    Gender findById(Integer id);
    List<Gender> findAll();
    void deleteById(Integer id);
    void save(Gender gender);
}
