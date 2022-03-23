package com.songexpert.controllers;


import com.songexpert.dto.BandDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.mappers.BandMapper;
import com.songexpert.services.BandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BandController {

    private final BandService bandService;
    private final BandMapper bandMapper;

    public BandController(BandService bandService, BandMapper bandMapper) {
        this.bandService = bandService;
        this.bandMapper = bandMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bandMapper.toDto(bandService.getById(id)), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<BandDTO>> getAll() {
        return new ResponseEntity<>(bandMapper
                .toDtoList(bandService.getAll()),
                HttpStatus.OK);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<BandDTO> create(@RequestBody BandDTO bandDTO) throws ElementAlreadyExistException {
        return new ResponseEntity<>(bandMapper
                .toDto(bandService.save(bandMapper.toEntity(bandDTO))), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody BandDTO bandDTO) {
        if (!id.equals(bandDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        bandService.update(bandMapper.toEntity(bandDTO));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        bandService.delete(bandService.getById(id));
        return HttpStatus.OK;
    }

}
