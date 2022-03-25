package com.songexpert.dao;

import com.songexpert.model.Genre;


public interface GenreDao extends BaseDao<Long, Genre> {
    boolean isExist (Genre genre);
}
