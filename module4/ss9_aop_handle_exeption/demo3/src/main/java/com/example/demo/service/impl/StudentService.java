package com.example.demo.service.impl;

import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import com.example.demo.repos.IBookRepo;
import com.example.demo.repos.IStudentRepo;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    final
    IStudentRepo repo;

    public StudentService(IStudentRepo repo) {
        this.repo = repo;
    }

    public List<Student> findAll(){
        return repo.findAll();
    }

    public Student findById(String id){
        return repo.findById(id).orElse(new Student());
    }
}
