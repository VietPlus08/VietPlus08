package com.codegym.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    Integer id;

    String content;

    String author;

    Integer mark;

    Date dateOfCreateComment = Date.valueOf(LocalDate.now());

    public BlogDto(Blog blog) {
        id = blog.id;
        content = blog.content;
        author = blog.author;
        mark = blog.mark;
        dateOfCreateComment = blog.dateOfCreateComment;
    }

}
