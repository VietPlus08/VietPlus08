package com.example.demo.aspect;

import com.example.demo.entity.Todo;
import com.example.demo.service.IService;
import org.aspectj.lang.JoinPoint;
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
    IService service;

    @Before("execution(* com.example.demo.controller.MainController.goList(..))")
    public void checkBeforeGoList(JoinPoint joinPoint){
        List<Todo> todoList = service.findAll().stream().filter
                (item -> Period.between(item.getDate().toLocalDate(), LocalDate.now()).getDays() > 1).collect(Collectors.toList());
        todoList.forEach(item -> {
            item.setDisplay(0);
            service.save(item);
        });

    }


}
