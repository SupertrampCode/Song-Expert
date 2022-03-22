package com.songexpert.controllers;

import com.songexpert.dto.MusicianDTO;
import com.songexpert.mappers.MusicianMapper;
import com.songexpert.services.MusicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/musician")
public class MusicianController {

    private final MusicianMapper musicianMapper;
    private final MusicianService musicianService;

    @Autowired
    public MusicianController(MusicianMapper musicianMapper, MusicianService musicianService) {
        this.musicianMapper = musicianMapper;
        this.musicianService = musicianService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicianDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(musicianMapper.toDto(musicianService.getById(id)),
                HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MusicianDTO>> getAll() {
        return new ResponseEntity<>(musicianMapper.toDtoList(musicianService.getAll()),
                HttpStatus.OK);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<MusicianDTO> create(@RequestBody MusicianDTO musicianDTO) {
        return new ResponseEntity<>(musicianMapper
                .toDto(musicianService.save(musicianMapper.toEntity(musicianDTO))),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody MusicianDTO musicianDTO) {
        if (!id.equals(musicianDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        musicianService.update(musicianMapper.toEntity(musicianDTO));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        musicianService.delete(musicianService.getById(id));
        return HttpStatus.OK;
    }
}

