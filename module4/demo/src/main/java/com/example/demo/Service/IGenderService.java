package com.example.demo.Service;

import com.example.demo.models.Gender;

import java.util.List;

public interface IGenderService {
    Gender findById(String id);
    List<Gender> findAll();


}
