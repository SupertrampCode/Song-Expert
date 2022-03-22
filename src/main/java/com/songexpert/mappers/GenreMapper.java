package com.songexpert.mappers;

import com.songexpert.dto.GenreDTO;
import com.songexpert.model.Genre;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GenreMapper {
    GenreDTO toDto(Genre genre);
    List<GenreDTO> toDtoList(List<Genre> genres);
    Genre toEntity(GenreDTO genreDTO);
}
