package com.todo.error;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleException implements ErrorController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> notFoundHandle(MethodArgumentNotValidException exception) {
        Map<String, String> map = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(x -> map.put(x.getField(), x.getDefaultMessage()));
        return map;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> notFoundHandle(NotFoundException e){
        Map<String, String> map = new HashMap<>();
        map.put("error message ",e.getMessage() );
        return map;
    }
}
