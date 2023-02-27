package bai_tap_2.controllers;

import java.util.List;

public interface IController<E> {
    void add(List<String> data);
    boolean remove(String code);
    List<E> findAll();
    List<E> findByNameOrCode(String data);
    E findByCode(String code);

}
