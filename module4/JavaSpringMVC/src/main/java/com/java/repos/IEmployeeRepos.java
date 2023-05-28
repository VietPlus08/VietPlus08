package com.java.repos;

import java.util.List;

import com.java.model.Employee;

 public interface IEmployeeRepos {
  List<Employee> findAll();

  Employee findById(String id);

  Employee save(Employee employee);
}
