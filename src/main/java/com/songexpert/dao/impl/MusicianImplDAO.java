package com.songexpert.dao.impl;

import com.songexpert.dao.MusicianDao;
import com.songexpert.model.Musician;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;


@Repository
public class MusicianImplDAO extends BasicImplDao<Long, Musician> implements MusicianDao {
    protected MusicianImplDAO() {
        super();
    }

    @Override
    public boolean isExist(Musician musician) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count (*) FROM Musician WHERE firstName=:firstName and lastName=:lastName and band.id=:bandId", Long.class)
                    .setParameter("firstName", musician.getFirstName())
                    .setParameter("lastName", musician.getLastName())
                    .setParameter("bandId", musician.getBand().getId())
                    .getSingleResult() > 0;
        }
    }
}
