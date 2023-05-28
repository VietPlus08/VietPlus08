package com.example.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "app_role")
public class AppRole {

    @Id
    @Column(name = "role_id", nullable = false)
    private int roleId;

    @Column(name = "role_name", length = 30, nullable = false, unique = true)
    private String roleName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appRole")
    Set<UserRole> userRoles;

}
