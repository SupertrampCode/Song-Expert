package com.songexpert.services;


import com.songexpert.model.Musician;

import java.util.List;

public interface MusicianService {

    Musician save(Musician musician);

    void delete(Musician musician);

    Musician getById(Long id);

    void update(Musician musician);

    List<Musician> getAll();
}
