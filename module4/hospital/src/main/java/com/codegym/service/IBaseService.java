package com.codegym.service;

import com.codegym.models.Person;

import java.util.List;
import java.util.Map;

public interface IBaseService<E> {
    List<String> findAllVehicle();

    List<String> findAllGender();

    List<String> findAllNation();

    List<String> findAllCity();

    List<String> findAllDistrict();

    List<String> findAllSubDistrict();

    Map<Integer, Person> findAllPerson();

    E findById(int id);

    void save(E e);

    void update(int id, E e);
}
