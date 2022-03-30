package com.songexpert.services.impl;

import com.songexpert.dao.MusicianDao;
import com.songexpert.dto.MusicianDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.exceptions.ElementNotExist;
import com.songexpert.mappers.MusicianMapper;
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
    private final MusicianMapper musicianMapper;

    @Autowired
    public MusicianServiceImpl(MusicianDao musicianDao, MusicianMapper musicianMapper) {
        this.musicianDao = musicianDao;
        this.musicianMapper = musicianMapper;
    }

    @Override
    public MusicianDTO save(MusicianDTO musicianDTO) {
        Musician musician = musicianMapper.toEntity(musicianDTO);
        if (musicianDao.isExist(musician)) {
            throw new ElementAlreadyExistException("Musician: " + musician.getFirstName() + " " + musician.getLastName() + " is already exist!");
        }
        return musicianMapper.toDto(musicianDao.save(musician));
    }

    @Override
    public void delete(Long id) {
        Musician musician = musicianDao.findById(id);
        if (musician == null) {
            throw new ElementNotExist("This musician doesn't exist.");
        }
        musicianDao.delete(musician);
    }

    @Override
    @Transactional(readOnly = true)
    public MusicianDTO findById(Long id) {
        return musicianMapper.toDto(musicianDao.findById(id));
    }

    @Override
    public MusicianDTO update(MusicianDTO musicianDTO) {
        return musicianMapper.toDto(musicianDao.update(musicianMapper.toEntity(musicianDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<MusicianDTO> getAll() {
        return musicianMapper.toDtoList(musicianDao.getAll());
    }
}
