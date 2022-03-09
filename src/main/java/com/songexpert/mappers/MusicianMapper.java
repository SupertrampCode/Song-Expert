package com.songexpert.mappers;

import com.songexpert.dto.MusicianDTO;
import com.songexpert.model.Musician;
import org.mapstruct.Mapper;

@Mapper
public interface MusicianMapper {
    MusicianDTO toDto (Musician musician);
    Musician toEntity (MusicianDTO musicianDTO);
}
