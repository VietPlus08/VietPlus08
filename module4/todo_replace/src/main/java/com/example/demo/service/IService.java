package com.example.demo.service;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.entity.Todo;

import java.util.List;

public interface IService {

    List<TodoDTO> findAllDTO();

    List<Todo> findAll();

    void updateById(Integer id);

    void save(TodoDTO todoDTO);

    void save(Todo todo);

}
