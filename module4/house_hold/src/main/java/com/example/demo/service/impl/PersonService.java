package com.example.demo.service.impl;

import com.example.demo.entity.Person;
import com.example.demo.repo.IPersonRepo;
import com.example.demo.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class PersonService implements IPersonService {
    @Autowired
    IPersonRepo repo;

    @Override
    public Integer countByHouseId(Integer houseId) {
        return repo.countByHouseId(houseId);
    }

    @Override
    public String personInHouse(Integer houseId) {
        StringBuilder personString = new StringBuilder();
        Stream<Person> personList = repo.findAll().stream().filter(item -> item.getHouse().getId() == houseId);
        personList.forEach(item -> personString.append(item.getName()));
        return String.valueOf(personString);
    }
}
