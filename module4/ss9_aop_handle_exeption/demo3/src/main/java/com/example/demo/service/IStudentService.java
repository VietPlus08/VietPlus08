package com.example.demo.service;

import com.example.demo.entities.Student;

import java.util.List;

public interface IStudentService {

    List<Student> findAll();

    Student findById(String id);
}
