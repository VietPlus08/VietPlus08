package com.example.demo.repos;

import ch.qos.logback.core.boolex.EvaluationException;
import com.example.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAppUserRepo extends JpaRepository<AppUser, Integer> {

    @Query(value = "select * from app_user where user_name = ?1", nativeQuery = true)
    AppUser findByUserName(String name);
}
