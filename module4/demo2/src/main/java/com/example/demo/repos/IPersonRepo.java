package com.example.demo.repos;

import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepo extends JpaRepository<Person,String> {

}
