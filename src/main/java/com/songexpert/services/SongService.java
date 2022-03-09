package com.songexpert.services;

import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;

import java.util.List;

public interface SongService {

    Song saveSong(Song song);

    void deleteSong(Song song);

    Song getSong(Song song);

    void updateInfo(Song song);

    List<Song> findByName (String name);

    List<Song> songsByBand(String bandName);

    List<Song> songsByGenre(Genre genre);


}
