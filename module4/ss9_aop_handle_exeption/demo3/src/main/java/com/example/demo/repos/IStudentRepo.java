package com.example.demo.repos;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student, String> {

}
