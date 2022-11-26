package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "todo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "date_begin")
    Date date;

    @Column(name = "display")
    Integer display;
}
