package com.songexpert.services.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import com.songexpert.services.SongService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongServiceImpl implements SongService {

    private final SongDao songDao;
    private SessionFactory sessionFactory;

    @Autowired
    public SongServiceImpl(SongDao songDao, SessionFactory sessionFactory) {
        this.songDao = songDao;
        this.sessionFactory=sessionFactory;
    }

    public Song saveSong(Song song) {
        return songDao.save(song);
    }

    public void deleteSong(Song song) {
        songDao.delete(song.getId());
    }

    @Transactional(readOnly=true)
    public Song getSong(Song song) {
        return songDao.findById(song.getId());
    }

    public void updateInfo(Song song) {
        songDao.update(song);
    }

    public List<Song> songsByGenre(Genre genre) {
        return songDao.getAllByGenre(genre);
    }

    @Override
    public List<Song> findByName(String name) {
        return sessionFactory.openSession().createQuery("FROM Song WHERE name=:name",Song.class).getResultList();
    }

    @Override
    public List<Song> songsByBand(String bandName) {
        return sessionFactory.openSession()
                .createQuery("FROM Song WHERE band.name like:name",Song.class)
                .setParameter("name",bandName)
                .getResultList();
    }
}
