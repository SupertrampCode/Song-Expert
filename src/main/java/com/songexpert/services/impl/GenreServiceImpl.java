package com.songexpert.services.impl;

import com.songexpert.dao.GenreDao;
import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.songexpert.services.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {
//
//    private GenreDao genreDao;
//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public GenreServiceImpl(GenreDao genreDao, SessionFactory sessionFactory) {
//        this.genreDao = genreDao;
//        this.sessionFactory=sessionFactory;
//    }
//
//    @Override
//    public List<Band> findBandsByGenre(Genre genre) {
//        sessionFactory.openSession().createQuery("FROM Band where genre.id=: param")
//    }
}
