package com.songexpert.dao.impl;

import com.songexpert.dao.MusicianDao;
import com.songexpert.model.Musician;
import org.springframework.stereotype.Repository;


@Repository
public class MusicianImplDAO extends BasicImplDao<Long, Musician> implements MusicianDao {
    protected MusicianImplDAO() {
        super();
    }
}
