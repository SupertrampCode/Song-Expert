package com.songexpert.services;

import com.songexpert.model.Genre;

import java.util.List;


public interface GenreService {

    Genre save(Genre genre);

    void delete(Genre genre);

    Genre getById(Long id);

    void update(Genre genre);

    List<Genre> getAll ();

    boolean checkIdentity (Genre genre);

}
