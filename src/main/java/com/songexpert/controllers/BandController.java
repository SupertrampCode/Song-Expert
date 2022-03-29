package com.songexpert.controllers;


import com.songexpert.dto.BandDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.services.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bands")
public class BandController {

    private final BandService bandService;

    @Autowired
    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BandDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bandService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BandDTO>> getAll() {
        return new ResponseEntity<>(bandService.getAll(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BandDTO> create(@RequestBody BandDTO bandDTO) throws ElementAlreadyExistException {
        return new ResponseEntity<>(bandService.save(bandDTO), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<BandDTO> update(@RequestBody BandDTO bandDTO) {
        return new ResponseEntity<>(bandService.update(bandDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        bandService.delete(id);
        return HttpStatus.OK;
    }

}
