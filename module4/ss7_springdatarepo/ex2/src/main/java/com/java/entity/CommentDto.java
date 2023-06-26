package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    Integer id;

    Integer mark;

    String author;

    String feedback;

    public CommentDto(Comment comment) {
        id = comment.id;
        mark = comment.mark;
        author = comment.author;
        feedback = comment.feedback;
    }

}
