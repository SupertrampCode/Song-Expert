package com.songexpert.dao.impl;

import com.songexpert.dao.GenreDao;
import com.songexpert.model.Genre;
import org.springframework.stereotype.Repository;

@Repository
public class GenreImpDAO extends BasicImplDao<Long, Genre> implements GenreDao {
    public GenreImpDAO() {
        super();
    }

}
