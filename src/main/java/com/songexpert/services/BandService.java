package com.songexpert.services;


import com.songexpert.dto.BandDTO;

import java.util.List;

public interface BandService {

    BandDTO save(BandDTO bandDTO);

    void delete(Long id);

    BandDTO findById(Long id);

    BandDTO update(BandDTO bandDTO);

    List<BandDTO> getAll();
}
