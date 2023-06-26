package com.example.demo.repos;

import com.example.demo.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepo extends JpaRepository<AppRole, Integer> {
}
