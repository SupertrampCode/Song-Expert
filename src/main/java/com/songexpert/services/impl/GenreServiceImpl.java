package com.songexpert.services.impl;

import com.songexpert.dao.GenreDao;
import com.songexpert.model.Genre;
import com.songexpert.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Autowired
    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public Genre save(Genre genre) {
        return genreDao.save(genre);
    }


    @Override
    public void delete(Genre genre) {
        genreDao.delete(genre);
    }

    @Override
    public Genre getById(Long id) {
        return genreDao.findById(id);
    }

    @Override
    public void update(Genre genre) {
        genreDao.update(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Override
    public boolean checkIdentity(Genre genre) {
        return getAll().stream().anyMatch(g -> g.checkIdentity(genre));
    }
}
