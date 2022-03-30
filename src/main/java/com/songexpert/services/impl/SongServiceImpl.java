package com.songexpert.services.impl;

import com.songexpert.dao.SongDao;
import com.songexpert.dto.SongDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.exceptions.ElementNotExist;
import com.songexpert.mappers.SongMapper;
import com.songexpert.model.Song;
import com.songexpert.services.SongService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
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
        Song song = songMapper.toEntity(songDTO);
        if (songDao.isExist(song)) {
            throw new ElementAlreadyExistException("Song: " + song.getName() + " is already exist!");
        }
        return songMapper.toDto(songDao.save(song));
    }

    public void delete(Long id) {
        Song song = songDao.findById(id);
        if (song == null) {
            throw new ElementNotExist("This song doesn't exist.");
        }
        songDao.delete(song);
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
    public SongDTO update(SongDTO songDTO) {
        return songMapper.toDto(songDao.update(songMapper.toEntity(songDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<SongDTO> songsByGenre(String genreName) {
        try (Session session = sessionFactory.openSession()) {
            return songMapper.toDtoList(session.createQuery("FROM Song WHERE genre.name like:name", Song.class)
                    .setParameter("name", "%" + genreName + "%")
                    .getResultList());
        }
    }

    @Override
    public List<SongDTO> getNewest() {
        try (Session session = sessionFactory.openSession()) {
            return songMapper
                    .toDtoList(session
                            .createQuery("FROM Song ORDER BY created DESC", Song.class)
                            .setMaxResults(10)
                            .getResultList()
                    );
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
