package com.java.service;

import java.util.List;

import com.java.model.Employee;
import com.java.repos.EmployeeReposImpl;
import com.java.repos.IEmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    IEmployeeRepos repos;

    public EmployeeService(EmployeeReposImpl employeeRepos) {
        this.repos = employeeRepos;
    }

    @Override
    public List<Employee> findAll() {
        System.out.println("findALl");
        return repos.findAll();
    }

    @Override
    public Employee findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        // TODO Auto-generated method stub
        return null;
    }

}
