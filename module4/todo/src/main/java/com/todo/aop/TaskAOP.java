package com.todo.aop;

import com.todo.entity.Action;
import com.todo.service.IActionService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Aspect
@Configuration
public class TaskAOP {
    @Autowired
    IActionService service;

    @Before("execution(* com.todo.controller.TaskController.findAllInOneDayAfterAndStatusIsIncomplete(..))")
    public void changeStatusAfterOneDayNoDoThis() {
        List<Action> list = service.findAllByTimeBeginBeforeAndStatusIsContaining(Timestamp.valueOf(LocalDateTime.now().plusDays(-1)), "incomplete");
        list.forEach(x -> {
            x.setStatus("cancel");
            x.setTimeFinish(Timestamp.valueOf(LocalDateTime.now()));
            service.save(x);
        });
    }
}
