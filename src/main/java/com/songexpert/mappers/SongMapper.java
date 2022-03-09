package com.songexpert.mappers;

import com.songexpert.dto.SongDTO;
import com.songexpert.model.Song;
import org.mapstruct.Mapper;

@Mapper
public interface SongMapper {
    SongDTO toDto(Song song);
    Song toEntity(SongDTO songDTO);
}
