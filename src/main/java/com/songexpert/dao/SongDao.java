package com.songexpert.dao;

import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;

import java.util.List;


public interface SongDao extends BaseDao<Long, Song> {

    List<Song> getAllByBand(Band band);

    List<Song> getAllByGenre(Genre genre);

}
