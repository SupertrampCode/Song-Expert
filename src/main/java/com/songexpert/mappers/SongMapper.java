package com.songexpert.mappers;

import com.songexpert.dto.SongDTO;
import com.songexpert.model.Song;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SongMapper {
    SongDTO toDto(Song song);

    List<SongDTO> toDtoList(List<Song> songs);

    Song toEntity(SongDTO songDTO);
}
