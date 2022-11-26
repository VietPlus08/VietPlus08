package com.example.demo.DTO;

import com.example.demo.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class TodoDTO {

    private Integer id;
    @NotBlank (message = "title it not empty")
    private String title;
    @NotBlank (message = "content it not empty")
    private String content;

    public TodoDTO(Todo todo){
        id = todo.getId();
        title = todo.getTitle();
        content = todo.getContent();
    }

}
