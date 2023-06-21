package com.java.entity;

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

    @Column
    String content;

    @Column
    Integer mark;

    @Column
    String author;

    @Column
    Date dateOfCreateComment;

    @Column
    boolean status;

    public Blog(BlogDto blogDto){
        content = blogDto.getContent();
        mark = 1;
        author = blogDto.getAuthor();
        dateOfCreateComment = Date.valueOf(LocalDate.now());
        status = true;
    }
}
