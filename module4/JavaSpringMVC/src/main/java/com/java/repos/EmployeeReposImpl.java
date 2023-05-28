package com.java.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.model.Employee;

@Transactional
 public class EmployeeReposImpl implements IEmployeeRepos {
  private SessionFactory sessionFactory;

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public List<Employee> findAll() {
    Session session = sessionFactory.getCurrentSession();
      return session.createQuery("select e from Employee e", Employee.class)
        .getResultList();
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
