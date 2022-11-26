package com.example.demo.service.impl;

import com.example.demo.model.Todo;
import com.example.demo.model.TodoDTO;
import com.example.demo.repo.ITodoRepo;
import com.example.demo.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService implements ITodoService {

    @Autowired
    ITodoRepo repo;

    @Override
    public List<Todo> findAll() {
        return repo.findByDisplayEquals();
//        return repo.findAll().stream().filter(x -> x.getDisplay() == 1).collect(Collectors.toList());
    }

    public List<TodoDTO> findAllDTO() {
        List<Todo> todoList = repo.findByDisplayEquals();
        List<TodoDTO> todoDTOList = new ArrayList<>();
        todoList.forEach(item -> {
            todoDTOList.add(new TodoDTO(item));
        });
        return todoDTOList;
    }

    @Override
    public void save(Todo todo) {
        repo.save(todo);
    }

    @Override
    public void save(TodoDTO todoDTO) {
        repo.save(todoDTO.getTitle(), todoDTO.getContent(), Date.valueOf(LocalDate.now()));
    }

    @Override
    public void updateById(Integer id) {
        repo.updateById(id);
    }

    @Override
    public void delete(Integer id) {
        Todo item = repo.findAll().stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        item.setDisplay(0);
        repo.save(item);
    }
}
