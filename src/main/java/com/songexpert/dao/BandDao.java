package com.songexpert.dao;

import com.songexpert.model.Band;


public interface BandDao extends BaseDao<Long, Band> {
    boolean isExist(Band band);
}
