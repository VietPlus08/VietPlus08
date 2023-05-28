package com.todo.service;

import com.todo.dao.ActionDAO;
import com.todo.entity.Action;

import java.sql.Timestamp;
import java.util.List;

public interface IActionService {

    void save(ActionDAO actionDAO);

    void save(Action action);

    List<Action> findAllByTimeBeginAfterAndStatusIsContaining(Timestamp date, String status);

    List<Action> findAllByTimeBeginBeforeAndStatusIsContaining(Timestamp localDateTime, String status);

    void updateById(Long id, String status);

    List<Action> findAll();
}
