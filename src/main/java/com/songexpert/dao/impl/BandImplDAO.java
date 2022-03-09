package com.songexpert.dao.impl;

import com.songexpert.dao.BandDao;
import com.songexpert.model.Band;
import org.springframework.stereotype.Repository;

@Repository
public class BandImplDAO extends BasicImplDao<Long, Band> implements BandDao {
    public BandImplDAO() {
        super();
    }

}
