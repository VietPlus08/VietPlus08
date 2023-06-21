package com.java.repo;

import com.java.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song, Integer> {
}
