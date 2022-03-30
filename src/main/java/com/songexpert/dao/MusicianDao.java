package com.songexpert.dao;

import com.songexpert.model.Musician;


public interface MusicianDao extends BaseDao<Long, Musician> {

    boolean isExist(Musician musician);
}
