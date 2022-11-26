package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoDTO;

import java.util.List;

public interface ITodoService {

    List<Todo> findAll();

    List<TodoDTO> findAllDTO();

    void save(Todo todo);

    void save(TodoDTO todoDTO);

    void delete(Integer id);

    void updateById(Integer id);

}
