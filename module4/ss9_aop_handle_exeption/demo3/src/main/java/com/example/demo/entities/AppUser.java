package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "user_name", length = 36, nullable = false, unique = true)
    private String userName;

    @Column(name = "encryted_password", length = 128, nullable = false)
    private String encrytedPassword;

    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    Set<UserRole> userRoles;
}
