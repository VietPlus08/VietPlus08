package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private String quantity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
    Set<Borrow> borrows;

}
