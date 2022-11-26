package com.todo.controller;

import com.todo.dao.ActionDAO;
import com.todo.entity.Action;
import com.todo.service.IActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    IActionService service;

    @GetMapping("")
    public ResponseEntity<Iterable<Action>> findAllInOneDayAfterAndStatusIsIncomplete() {
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now().plusDays(-1));
        return new ResponseEntity<>(service.findAllByTimeBeginAfterAndStatusIsContaining(timestamp, "incomplete"), HttpStatus.OK);
    }

    @GetMapping("/lists")
    public ResponseEntity<Iterable<Action>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Iterable<Action>> saveEntity(@Valid @RequestBody ActionDAO actionDAO) {
        service.save(actionDAO);
        return findAllInOneDayAfterAndStatusIsIncomplete();
    }

    @PatchMapping(value = "/{action}/id/{id}")
    public ResponseEntity<Iterable<Action>> updateEntityCompete(@PathVariable("id") Long id, @PathVariable("action") String action) {
        service.updateById(id, action);
        return findAllInOneDayAfterAndStatusIsIncomplete();
    }
}
