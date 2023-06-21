package com.java.service;

import com.java.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(int id);

    void save(Song song);

    void delete(Song song);
}
