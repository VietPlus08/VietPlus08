package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Id
    private String id;

    @Column (name = "name")
    @NotBlank (message = "name not blank")
    private String name;

}
