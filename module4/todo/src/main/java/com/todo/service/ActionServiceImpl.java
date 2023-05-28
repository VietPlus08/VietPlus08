package com.todo.service;

import com.todo.dao.ActionDAO;
import com.todo.entity.Action;
import com.todo.error.NotFoundException;
import com.todo.repository.IActionRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements IActionService {
    @Autowired
    IActionRepository repository;


    @Override
    public void save(ActionDAO actionDAO) {
        repository.save(actionDAO.getTitle(), actionDAO.getContent(), Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public void save(Action action) {
        repository.save(action);
    }

    @Override
    public List<Action> findAllByTimeBeginAfterAndStatusIsContaining(Timestamp date, String status) {
        return repository.findAllByTimeBeginAfterAndStatusIsContaining(date, status);
    }

    @Override
    public List<Action> findAllByTimeBeginBeforeAndStatusIsContaining(Timestamp localDateTime, String status) {
        return repository.findAllByTimeBeginBeforeAndStatusIsContaining(localDateTime, status);
    }

    @SneakyThrows
    @Override
    public void updateById(Long id, String status) {
        Optional<Action> action = repository.findById(id);
        if (action.isPresent()) {
            action.get().setStatus(status);
            repository.save(action.get());
            return;
        }
        throw new NotFoundException("Not found this action " + id + " to update!!!");
    }

    @Override
    public List<Action> findAll() {
        return repository.findAll();
    }
}
