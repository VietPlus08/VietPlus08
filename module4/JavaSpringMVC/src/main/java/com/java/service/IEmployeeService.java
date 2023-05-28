package com.java.service;

import java.util.List;

import com.java.model.Employee;

public interface IEmployeeService {
  List<Employee> findAll();

  Employee findById(String id);

  Employee save(Employee employee);
}
