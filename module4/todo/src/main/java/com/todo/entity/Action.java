package com.todo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "action")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_begin",columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private Timestamp timeBegin;

    @Column(name = "time_finish",columnDefinition = "DATETIME")
    private Timestamp timeFinish;

    String title;


    String content;

    @Column(name = "status",columnDefinition = "VARCHAR(50) DEFAULT 'incomplete'")
    String status;


}
