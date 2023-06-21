package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column
    String name;
    @Column
    String artist;
    @Column
    String link;

    public Song(SongDto songDto){
        id = songDto.getId();
        name = songDto.getName();
        artist = songDto.getArtist();
        link = songDto.getLinkSong().getOriginalFilename();
    }

}
