package com.songexpert.dao.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SongImplDAO extends BasicImplDao<Long, Song> implements SongDao {

    SessionFactory sessionFactory;

    @Autowired
    public SongImplDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Song> getAllByBand(@NotNull Band band) {
        Session session = sessionFactory.openSession();
        List<Song> songs = session.createQuery("FROM Song WHERE band.id=:band", Song.class)
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

}
