package com.songexpert.dao.impl;

import com.songexpert.dao.BaseDao;
import customExceptions.NotFoundElementById;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaDelete;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Slf4j
public abstract class BasicImplDao<K extends Serializable, E> implements BaseDao<K, E> {

    protected final Class<E> baseClass;
    @Autowired
    protected SessionFactory sessionFactory;


    protected BasicImplDao() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.baseClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
    }


    @Override
    public E save(E entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
        return entity;
    }


    @Override
    public void delete(K id) {
        Session session = sessionFactory.openSession();
        session.delete(id);
        session.close();
    }

    @Override
    public void clear() {
        Session session = sessionFactory.openSession();
        CriteriaDelete<E> criteriaDelete = session.getCriteriaBuilder().createCriteriaDelete(baseClass);
        criteriaDelete.from(baseClass);
        session.close();
    }

    @Override
    public void update(E entity) {
        Session session = sessionFactory.openSession();
        session.update(entity);
        session.close();
    }

    @Override
    public E findById(K id) {
        Session session = sessionFactory.openSession();
        E entity = session.get(baseClass, id);
        if (entity == null) throw new NotFoundElementById();
        session.close();
        return entity;
    }

    @Override
    public List<E> findAll() {
        Session session = sessionFactory.openSession();
        session.setReadOnly(baseClass, true);
        var query = session.getCriteriaBuilder().createQuery(baseClass);
        query.from(baseClass);
        List<E> result = session.createQuery(query).getResultList();
        session.close();
        return result;
    }
}
