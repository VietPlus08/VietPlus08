package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    String id;

    @Column(name = "student_name")
    String name;

    @Column(name = "class_name")
    String className;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    Set<Borrow> borrows;

}
