package com.songexpert.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<K extends Serializable, E> {
    E save(E entity);

    void delete(K id);

    void clear();

    void update(E entity);

    E findById(K id);

    List<E> findAll();


}
