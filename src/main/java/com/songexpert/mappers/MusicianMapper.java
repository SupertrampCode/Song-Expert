package com.songexpert.mappers;

import com.songexpert.dto.MusicianDTO;
import com.songexpert.model.Musician;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MusicianMapper {
    MusicianDTO toDto(Musician musician);

    List<MusicianDTO> toDtoList(List<Musician> musicians);

    Musician toEntity(MusicianDTO musicianDTO);
}
