package com.songexpert.services.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.dto.SongDTO;
import com.songexpert.mappers.SongMapper;
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
    private final SongMapper songMapper;

    @Autowired
    public SongServiceImpl(SongDao songDao, SessionFactory sessionFactory, SongMapper songMapper) {
        this.songDao = songDao;
        this.sessionFactory = sessionFactory;
        this.songMapper = songMapper;
    }

    public SongDTO saveSong(SongDTO songDTO) {
        return songMapper.toDto(songDao.save(songMapper.toEntity(songDTO)));
    }

    public void delete(Long id) {
        songDao.delete(songDao.findById(id));
    }

    @Transactional(readOnly = true)
    public SongDTO findById(Long id) {
        return songMapper.toDto(songDao.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongDTO> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return songMapper.toDtoList(session.createQuery("FROM Song ", Song.class).getResultList());
        }
    }

    @Override
    public void update(SongDTO songDTO) {
        songDao.update(songMapper.toEntity(songDTO));
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public List<SongDTO> songsByGenre(String genreName) {
        try (Session session = sessionFactory.openSession()) {
            return songMapper.toDtoList(session.createQuery("FROM Song WHERE genre.name like:name", Song.class)
                    .setParameter("name", "%" + genreName + "%")
                    .getResultList());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongDTO> findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return songMapper.toDtoList(session.createQuery("FROM Song WHERE name=:name", Song.class).getResultList());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongDTO> songsByBand(String bandName) {
        try (Session session = sessionFactory.openSession()) {
            return songMapper.toDtoList(session.createQuery("FROM Song WHERE band.name like:name", Song.class)
                    .setParameter("name", "%" + bandName + "%")
                    .getResultList());
        }
    }
}
