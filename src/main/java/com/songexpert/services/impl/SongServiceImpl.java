package com.songexpert.services.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.model.Song;
import com.songexpert.services.SongService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongServiceImpl implements SongService {

    private final SongDao songDao;
    private final SessionFactory sessionFactory;

    @Autowired
    public SongServiceImpl(SongDao songDao, SessionFactory sessionFactory) {
        this.songDao = songDao;
        this.sessionFactory = sessionFactory;
    }

    public Song saveSong(Song song) {
        return songDao.save(song);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void deleteSong(Song song) {
        songDao.delete(song);
    }

    @Transactional(readOnly = true)
    public Song getSong(Long id) {
        return songDao.findById(id);
    }

    @Override
    public List<Song> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Song ", Song.class).getResultList();
        }
    }

    @Override
    public void update(Song song) {
        songDao.update(song);
    }

    public List<Song> songsByGenre(String genreName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Song WHERE genre.name like:name", Song.class)
                    .setParameter("name", "%" + genreName + "%")
                    .getResultList();
        }
    }

    @Override
    public List<Song> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Song WHERE name=:name", Song.class).getResultList();
        }

    }

    @Override
    public List<Song> songsByBand(String bandName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Song WHERE band.name like:name", Song.class)
                    .setParameter("name", "%" + bandName + "%")
                    .getResultList();
        }
    }
}
