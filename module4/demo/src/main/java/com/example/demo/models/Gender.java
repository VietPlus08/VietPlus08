package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Gender {
    @Id
    int id;
    @Column (name = "name" )
    String name;
}
