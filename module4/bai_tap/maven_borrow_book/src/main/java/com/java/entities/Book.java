package com.java.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Book {
    String id;
    String name;
    String author;
    String description;
    String quantity;

}
