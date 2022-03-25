package com.songexpert.services;


import com.songexpert.dto.MusicianDTO;

import java.util.List;

public interface MusicianService {

    MusicianDTO save(MusicianDTO musicianDTO);

    void delete(Long id);

    MusicianDTO findById(Long id);

    void update(MusicianDTO musicianDTO);

    List<MusicianDTO> getAll();
}
