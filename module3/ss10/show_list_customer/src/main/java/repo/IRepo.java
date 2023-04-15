package repo;

import entity.Customer;

import java.util.List;

public interface IRepo<E> {
    List<E> findAll();

    E findById(int id);

    void delete(int id);

    void save(E customer);

    List<Customer> findByIdOrName(String searchName);
}
