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
    public void delete(E entity) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(entity);
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
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public E findById(K id) {
        Session session = sessionFactory.openSession();
        E entity = session.get(baseClass, id);
        if (entity == null) throw new NotFoundElementById();
        session.close();
        return entity;
    }

    public List<E> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM " + baseClass.getName(), baseClass)
                .getResultList();
    }
}
