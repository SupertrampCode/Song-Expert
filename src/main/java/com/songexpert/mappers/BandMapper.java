package com.songexpert.mappers;

import com.songexpert.dto.BandDTO;
import com.songexpert.model.Band;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {MusicianMapper.class})
public interface BandMapper {
    BandDTO toDto(Band band);

    List<BandDTO> toDtoList(List<Band> bands);

    Band toEntity(BandDTO bandDTO);
}
