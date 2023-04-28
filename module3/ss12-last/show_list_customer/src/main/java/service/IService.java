package service;

import java.util.List;

public interface IService<E> {
    List<E> findAll(String index);

    E findById(int id);

    boolean delete(int id);

    boolean save(E customer);

    List<E> findByIdOrName(String id, String name, String index);

    boolean update(E customer);

    int pages();
}
