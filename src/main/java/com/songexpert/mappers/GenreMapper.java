package com.songexpert.mappers;

import com.songexpert.dto.GenreDTO;
import com.songexpert.model.Genre;
import org.mapstruct.Mapper;

@Mapper
public interface GenreMapper {
    GenreDTO toDto(Genre genre);
    Genre toEntity(GenreDTO genreDTO);
}
