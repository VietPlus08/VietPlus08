package com.java.service;

import com.java.entity.Song;
import com.java.repo.ISongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements ISongService {

    final ISongRepo songRepo;

    public SongServiceImpl(ISongRepo songRepo) {
        this.songRepo = songRepo;
    }


    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song findById(int id) {
        return songRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }

    @Override
    public void delete(Song song) {
        songRepo.delete(song);
    }
}
