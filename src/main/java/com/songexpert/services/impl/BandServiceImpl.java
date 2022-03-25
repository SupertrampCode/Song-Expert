package com.songexpert.services.impl;

import com.songexpert.dao.BandDao;
import com.songexpert.dto.BandDTO;
import com.songexpert.mappers.BandMapper;
import com.songexpert.model.Band;
import com.songexpert.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
        return bandMapper.toDto(bandDao.save(bandMapper.toEntity(bandDTO)));
    }

    @Override
    public void delete(Long id) {
    bandDao.delete(bandDao.findById(id));
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public BandDTO findById(Long id) {
        return bandMapper.toDto(bandDao.findById(id));
    }

    @Override
    public void update(BandDTO bandDTO) {
        bandDao.update(bandMapper.toEntity(bandDTO));
    }

    @Override
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public List<BandDTO> getAll() {
        return bandMapper.toDtoList(bandDao.getAll());
    }
}
