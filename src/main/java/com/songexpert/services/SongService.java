package com.songexpert.services;

import com.songexpert.model.Song;

import java.util.List;

public interface SongService {

    Song saveSong(Song song);

    void deleteSong(Song song);

    Song getSong(Long id);

    List<Song> getAll();

    void update(Song song);

    List<Song> findByName(String name);

    List<Song> songsByBand(String bandName);

    List<Song> songsByGenre(String genreName);


}
