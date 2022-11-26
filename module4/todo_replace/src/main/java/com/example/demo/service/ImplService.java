package com.example.demo.service;

import com.example.demo.DTO.TodoDTO;
import com.example.demo.entity.Todo;
import com.example.demo.repo.IRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImplService implements IService {

    @Autowired
    IRepo repo;

    @Override
    public List<TodoDTO> findAllDTO() {
        List<TodoDTO> todoDTOList = new ArrayList<>();
        repo.findByDisplay().forEach(item -> {
            todoDTOList.add(new TodoDTO(item.getId(), item.getTitle(), item.getContent()));
        });
        return todoDTOList;
    }

    @Override
    public List<Todo> findAll() {
        return repo.findByDisplay();
    }

    @Override
    public void updateById(Integer id) {
        repo.updateById(id);
    }

    @Override
    public void save(TodoDTO todoDTO) {
        repo.save(todoDTO.getTitle(), todoDTO.getContent(), Date.valueOf(LocalDate.now()));
    }

    @Override
    public void save(Todo todo) {
        repo.save(todo);
    }
}
