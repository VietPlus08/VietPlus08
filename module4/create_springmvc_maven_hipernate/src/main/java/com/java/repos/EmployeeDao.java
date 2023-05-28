package com.java.repos;

import com.java.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
//(rollbackFor = Exception.class)
public class EmployeeDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Employee> findAll(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("select e from Employee e", Employee.class).getResultList();
    }

    public Employee findById(final String id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Employee.class,id);
    }

    public void save(final Employee employee){
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }
    public void delete(final Employee employee){
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(employee);
    }
}
