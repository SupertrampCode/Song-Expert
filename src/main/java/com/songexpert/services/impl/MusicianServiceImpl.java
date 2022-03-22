package com.songexpert.services.impl;

import com.songexpert.dao.MusicianDao;
import com.songexpert.model.Musician;
import com.songexpert.services.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicianServiceImpl implements MusicianService {

    private final MusicianDao musicianDao;

    @Autowired
    public MusicianServiceImpl(MusicianDao musicianDao) {
        this.musicianDao = musicianDao;
    }

    @Override
    public Musician save(Musician musician) {
        return musicianDao.save(musician);
    }

    @Override
    public void delete(Musician musician) {
        musicianDao.save(musician);
    }

    @Override
    public Musician getById(Long id) {
        return musicianDao.findById(id);
    }

    @Override
    public void update(Musician musician) {
        musicianDao.update(musician);
    }

    @Override
    public List<Musician> getAll() {
        return musicianDao.getAll();
    }
}
