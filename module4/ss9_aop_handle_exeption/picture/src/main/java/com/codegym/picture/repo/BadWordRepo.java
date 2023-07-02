package com.codegym.picture.repo;

import com.codegym.picture.entity.BadWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadWordRepo extends JpaRepository<BadWord, Integer> {
}
