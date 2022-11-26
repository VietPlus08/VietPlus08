package com.todo.error;

public class NotFoundException extends Exception {
    public NotFoundException(String error) {
        super(error);
    }
}
