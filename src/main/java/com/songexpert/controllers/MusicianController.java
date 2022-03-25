package com.songexpert.controllers;

import com.songexpert.dto.MusicianDTO;
import com.songexpert.services.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicians")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MusicianController {

    private final MusicianService musicianService;

    @Autowired
    public MusicianController(MusicianService musicianService) {
        this.musicianService = musicianService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicianDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(musicianService.findById(id),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MusicianDTO>> getAll() {
        return new ResponseEntity<>(musicianService.getAll(),
                HttpStatus.OK);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<MusicianDTO> create(@RequestBody MusicianDTO musicianDTO) {
        return new ResponseEntity<>(musicianService.save(musicianDTO),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody MusicianDTO musicianDTO) {
        if (!id.equals(musicianDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        musicianService.update(musicianDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        musicianService.delete(id);
        return HttpStatus.OK;
    }
}

