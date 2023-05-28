package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "user_role",
        uniqueConstraints = {@UniqueConstraint(name = "uk_user_role", columnNames = {"user_id","role_id"})})
public class UserRole {

    @Id
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) //, foreignKey = @ForeignKey(name = "fk_book_borrow")
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private AppRole appRole;

}
