package com.songexpert.services;

import com.songexpert.dto.GenreDTO;

import java.util.List;


public interface GenreService {

    GenreDTO save(GenreDTO genreDTO);

    void delete(Long id);

    GenreDTO findById(Long id);

    void update(GenreDTO genreDTO);

    List<GenreDTO> getAll();

}
