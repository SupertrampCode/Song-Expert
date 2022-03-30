package com.songexpert.dao.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SongImplDAO extends BasicImplDao<Long, Song> implements SongDao {

    public List<Song> getAllByBand(@NotNull Band band) {
        Session session = sessionFactory.openSession();
        List<Song> songs = session.createQuery("select count (*) FROM Song WHERE band.id=:band", Song.class)
                .setParameter("band", band.getId())
                .getResultList();
        session.close();
        return songs;
    }


    public List<Song> getAllByGenre(@NotNull Genre genre) {
        Session session = sessionFactory.openSession();
        List<Song> songs = session.createQuery("FROM Song WHERE genre.id=:genre", Song.class)
                .setParameter("genre", genre.getId())
                .getResultList();
        session.close();
        return songs;
    }

    @Override
    public boolean isExist(Song song) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Song WHERE name=:name and genre.id=:genreID and band.id=:bandID", Long.class)
                    .setParameter("name", song.getName())
                    .setParameter("genreID", song.getGenre().getId())
                    .setParameter("bandID", song.getBand().getId())
                    .getSingleResult() > 0;
        }
    }
}
