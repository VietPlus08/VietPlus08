package com.codegym.picture.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
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
    Timestamp timeOfCreateComment;

    @Transient
    Date dateOfCreateComment;

    @Column
    boolean status;

    public Timestamp getTimeOfCreateComment() {
        return timeOfCreateComment;
    }

    public void setTimeOfCreateComment(Timestamp timeOfCreateComment) {
        this.timeOfCreateComment = timeOfCreateComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getDateOfCreateComment() {
        return dateOfCreateComment;
    }

    public void setDateOfCreateComment(Date dateOfCreateComment) {
        this.dateOfCreateComment = dateOfCreateComment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
