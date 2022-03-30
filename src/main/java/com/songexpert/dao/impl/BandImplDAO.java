package com.songexpert.dao.impl;

import com.songexpert.dao.BandDao;
import com.songexpert.model.Band;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class BandImplDAO extends BasicImplDao<Long, Band> implements BandDao {
    public BandImplDAO() {
        super();
    }

    public boolean isExist(Band band) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count (*) FROM Band WHERE name=:name", Long.class)
                    .setParameter("name", band.getName()).getSingleResult() > 0;
        }
    }
}
