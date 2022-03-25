package com.songexpert.services.impl;

import com.songexpert.dao.MusicianDao;
import com.songexpert.dto.MusicianDTO;
import com.songexpert.mappers.MusicianMapper;
import com.songexpert.model.Musician;
import com.songexpert.services.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicianServiceImpl implements MusicianService {

    private final MusicianDao musicianDao;
    private final MusicianMapper musicianMapper;

    @Autowired
    public MusicianServiceImpl(MusicianDao musicianDao, MusicianMapper musicianMapper) {
        this.musicianDao = musicianDao;
        this.musicianMapper = musicianMapper;
    }

    @Override
    public MusicianDTO save(MusicianDTO musicianDTO) {
        return musicianMapper.toDto(musicianDao.save(musicianMapper.toEntity(musicianDTO)));
    }

    @Override
    public void delete(Long id) {
        musicianDao.delete(musicianDao.findById(id));
    }

    @Override
    @Transactional(readOnly = true)
    public MusicianDTO findById(Long id) {
        return musicianMapper.toDto(musicianDao.findById(id));
    }

    @Override
    public void update(MusicianDTO musicianDTO) {
        musicianDao.update(musicianMapper.toEntity(musicianDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MusicianDTO> getAll() {
        return musicianMapper.toDtoList(musicianDao.getAll());
    }
}
