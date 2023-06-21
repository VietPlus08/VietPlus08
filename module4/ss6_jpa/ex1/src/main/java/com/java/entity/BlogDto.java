package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    Integer id;

    String content;

    String author;

    public BlogDto(Blog blog) {
        id = blog.id;
        content = blog.content;
        author = blog.author;
    }

}
