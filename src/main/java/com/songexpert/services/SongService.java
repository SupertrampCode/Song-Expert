package com.songexpert.services;

import com.songexpert.dto.SongDTO;

import java.util.List;

public interface SongService {

    SongDTO saveSong(SongDTO songDTO);

    void delete(Long id);

    SongDTO findById(Long id);

    List<SongDTO> getAll();

    SongDTO update(SongDTO songDTO);

    List<SongDTO> findByName(String name);

    List<SongDTO> songsByBand(String bandName);

    List<SongDTO> songsByGenre(String genreName);

    List<SongDTO> getNewest();

}
