package service;

import java.util.List;

public interface IService<E> {
    List<E> findAll(String search, int index);

    E findById(int id);

    boolean delete (int id);

    void save(E e);

    int countAllFromProduct();
}
