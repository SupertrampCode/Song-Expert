package com.songexpert.services.impl;

import com.songexpert.dao.BandDao;
import com.songexpert.model.Band;
import com.songexpert.services.BandService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BandServiceImpl implements BandService {

    private final BandDao bandDao;

    public BandServiceImpl(BandDao bandDao) {
        this.bandDao = bandDao;
    }

    @Override
    public Band save(Band band) {
        return bandDao.save(band);
    }

    @Override
    public void delete(Band band) {
    bandDao.delete(band);
    }

    @Override
    public Band getById(Long id) {
        return bandDao.findById(id);
    }

    @Override
    public void update(Band band) {
        bandDao.update(band);
    }

    @Override
    public List<Band> getAll() {
        return bandDao.getAll();
    }
}
