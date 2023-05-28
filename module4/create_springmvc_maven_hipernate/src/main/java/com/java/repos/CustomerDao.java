package com.java.repos;

import com.java.entities.Customer;
import com.java.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Customer> findAll(){
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("select e from Customer e", Customer.class).getResultList();
    }

    public Customer findById(final String id) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.get(Customer.class,id);
    }

    public void save(final Customer c){
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(c);
    }
    public void delete(final Customer c){
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(c);
    }
}
