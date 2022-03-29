package com.songexpert.services.impl;

import com.songexpert.dao.BandDao;
import com.songexpert.dto.BandDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.exceptions.ElementNotExist;
import com.songexpert.mappers.BandMapper;
import com.songexpert.model.Band;
import com.songexpert.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BandServiceImpl implements BandService {

    private final BandDao bandDao;
    private final BandMapper bandMapper;

    @Autowired
    public BandServiceImpl(BandDao bandDao, BandMapper bandMapper) {
        this.bandDao = bandDao;
        this.bandMapper = bandMapper;
    }

    @Override
    public BandDTO save(BandDTO bandDTO) {
        Band band = bandMapper.toEntity(bandDTO);
        if (bandDao.isExist(band)) {
            throw new ElementAlreadyExistException("Band:" + band.getName() + " is already exist!");
        }
        return bandMapper.toDto(bandDao.save(band));
    }

    @Override
    public void delete(Long id) {
        Band band = bandDao.findById(id);
        if (band==null) {
            throw new ElementNotExist("This band doesn't exist");
        }
        bandDao.delete(band);
    }

    @Override
    @Transactional(readOnly = true)
    public BandDTO findById(Long id) {
        return bandMapper.toDto(bandDao.findById(id));
    }

    @Override
    public BandDTO update(BandDTO bandDTO) {
        return bandMapper.toDto(bandDao.update(bandMapper.toEntity(bandDTO)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<BandDTO> getAll() {
        return bandMapper.toDtoList(bandDao.getAll());
    }
}
