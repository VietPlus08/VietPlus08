package com.todo.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActionDAO {
    @NotBlank(message = "title should be something")
    String title;

    @NotBlank(message = "content should be something")
    String content;
}
