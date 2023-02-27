package bai_tap_1.controllers;

import java.util.List;

public interface IController<E> {
    void add(List<String> e);
    boolean remove(String id);
    List<E> findAll();
    List<E> findById(String id);
}
