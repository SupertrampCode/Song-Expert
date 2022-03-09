package com.songexpert.mappers;

import com.songexpert.dto.BandDTO;
import com.songexpert.model.Band;
import org.mapstruct.Mapper;

@Mapper(uses = {MusicianMapper.class})
public interface BandMapper {
    BandDTO toDto (Band band);
    Band toEntity (BandDTO bandDTO);
}
