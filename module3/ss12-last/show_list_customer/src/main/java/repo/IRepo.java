package repo;

import entity.Customer;

import java.util.List;

public interface IRepo<E> {

    List<E> findAll(String index);

    E findById(int id);

    boolean delete(int id);

    void save(E e);

    List<Customer> findByIdOrName(String id, String name, String index);

    boolean update(E e);

    int countItem();
}
