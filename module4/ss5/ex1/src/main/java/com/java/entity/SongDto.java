package com.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {
    Integer id;
    String name;
    String artist;
    MultipartFile linkSong;

    public SongDto(Song song){
        id = song.getId();
        name = song.getName();
        artist = song.getArtist();
//        linkSong = song.getLink();
    }

}
