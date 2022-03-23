package com.songexpert.services;


import com.songexpert.model.Band;

import java.util.List;

public interface BandService {

    Band save(Band band);

    void delete(Band band);

    Band getById(Long id);

    void update(Band band);

    List<Band> getAll();
}
