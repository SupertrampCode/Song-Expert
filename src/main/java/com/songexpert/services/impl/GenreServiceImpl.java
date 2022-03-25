package com.songexpert.services.impl;

import com.songexpert.dao.GenreDao;
import com.songexpert.dto.GenreDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.mappers.GenreMapper;
import com.songexpert.model.Genre;
import com.songexpert.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;
    private final GenreMapper genreMapper;

    @Autowired
    public GenreServiceImpl(GenreDao genreDao, GenreMapper genreMapper) {
        this.genreDao = genreDao;
        this.genreMapper = genreMapper;
    }


    public GenreDTO save(GenreDTO genreDTO) {
        Genre genre = genreMapper.toEntity(genreDTO);
        if (genreDao.isExist(genre)) {
            throw new ElementAlreadyExistException("Genre: " + genre.getName() + " is already exist");
        }
        return genreMapper.toDto(genreDao.save(genre));
    }

    @Override
    public void delete(Long id) {
        genreDao.delete(genreDao.findById(id));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public GenreDTO findById(Long id) {
        return genreMapper.toDto(genreDao.findById(id));
    }

    @Override
    public void update(GenreDTO genreDTO) {
        genreDao.update(genreMapper.toEntity(genreDTO));
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public List<GenreDTO> getAll() {
        return genreMapper.toDtoList(genreDao.getAll());
    }
}
