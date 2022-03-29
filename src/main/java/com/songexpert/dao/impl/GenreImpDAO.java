package com.songexpert.dao.impl;

import com.songexpert.dao.GenreDao;
import com.songexpert.model.Genre;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class GenreImpDAO extends BasicImplDao<Long, Genre> implements GenreDao {
    public GenreImpDAO() {
        super();
    }

    public boolean isExist(Genre genre) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("select count (*) FROM Genre WHERE name=:name", Long.class)
                    .setParameter("name", genre.getName()).getSingleResult() > 0;
        }
    }

}
