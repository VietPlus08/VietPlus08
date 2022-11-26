package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {


    private String title;
    private String content;

    public TodoDTO(Todo todo) {
        title = todo.getTitle();
        content = todo.getContent();
    }

}
