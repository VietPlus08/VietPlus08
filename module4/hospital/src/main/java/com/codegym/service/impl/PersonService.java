package com.codegym.service.impl;

import com.codegym.models.Person;
import com.codegym.repository.IBaseRepository;
import com.codegym.repository.impl.PersonRepository;
import com.codegym.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService implements IBaseService<Person> {
    @Autowired
    IBaseRepository<Person> repository = new PersonRepository();

    @Override
    public List<String> findAllVehicle() {
        return repository.findAllVehicle();
    }

    @Override
    public List<String> findAllGender() {
        return repository.findAllGender();
    }

    @Override
    public List<String> findAllNation() {
        return repository.findAllNation();
    }

    @Override
    public List<String> findAllCity() {
        return repository.findAllCity();
    }

    @Override
    public List<String> findAllDistrict() {
        return repository.findAllDistrict();
    }

    @Override
    public List<String> findAllSubDistrict() {
        return repository.findAllSubDistrict();
    }

    @Override
    public Map<Integer, Person> findAllPerson() {
        return repository.findAllPerson();
    }

    @Override
    public Person findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(Person person) {
        repository.save(person);
    }

    @Override
    public void update(int id, Person person) {
        repository.update(id, person);
    }
}
