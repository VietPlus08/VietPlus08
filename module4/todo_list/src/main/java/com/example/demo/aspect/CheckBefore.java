package com.example.demo.aspect;

import com.example.demo.model.Todo;
import com.example.demo.service.ITodoService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Configuration
public class CheckBefore {
    Logger logger = LoggerFactory.getLogger(CheckBefore.class);

    @Autowired
    ITodoService service;

    @Before("execution( * com.example.demo.controller.MainController.goList(..))")
    public void checkBeforeGoList(JoinPoint joinPoint) {
        List<Todo> list = service.findAll().stream().filter
                (x -> Period.between(x.getDate().toLocalDate(), LocalDate.now()).getDays() > 1).collect(Collectors.toList());

        for (Todo todo : list) {
            todo.setDisplay(0);
            service.save(todo);
        }
        logger.info("Here begin {}", joinPoint);
    }

    @After("execution( * com.example.demo.controller.MainController.goList(..))")
    public void checkAfterGoList(JoinPoint joinPoint) {
        logger.info("Herre end {}", joinPoint);
    }

}
