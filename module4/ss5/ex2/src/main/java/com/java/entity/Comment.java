package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    Integer mark;

    @Column
    String author;

    @Column
    String feedback;

    @Column
    Date dateOfCreateComment;

    @Column
    boolean status;

    public Comment(CommentDto commentDto){
        mark = commentDto.getMark();
        author = commentDto.getAuthor();
        feedback = commentDto.getFeedback();
        dateOfCreateComment = Date.valueOf(LocalDate.now());
        status = true;
    }
}
