package service;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E findById(int id);

    void delete(int id);

    void save(E customer);

    List<E> findByIdOrName(String searchName);
}
