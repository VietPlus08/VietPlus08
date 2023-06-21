package com.codegym.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column (name = "content")
    String content;

    @Column (name = "mark")
    Integer mark;

    @Column (name = "author")
    String author;

    @Column (name = "dateOfCreateComment")
    Date dateOfCreateComment;

    @Column
    boolean status;

    public Blog(BlogDto blogDto){
        content = blogDto.getContent();
        mark = 1;
        author = blogDto.getAuthor();
        dateOfCreateComment = blogDto.getDateOfCreateComment();
        status = true;
    }
}
