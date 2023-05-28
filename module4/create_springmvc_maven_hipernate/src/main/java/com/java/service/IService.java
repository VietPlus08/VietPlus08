package com.java.service;

import com.java.entities.Employee;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E getById(String id);

    void save(Employee employee);

    void delete(Employee employee);
}
