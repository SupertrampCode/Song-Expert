package com.songexpert.controllers;


import com.songexpert.dto.SongDTO;
import com.songexpert.mappers.SongMapper;
import com.songexpert.model.Band;
import com.songexpert.model.Genre;
import com.songexpert.model.Song;
import com.songexpert.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;
    private final SongMapper songMapper;


    public SongController(SongService songService, SongMapper songMapper) {
        this.songService = songService;
        this.songMapper = songMapper;
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(songService.findByName(name).stream().map(songMapper::toDto).collect(Collectors.toList()),
                HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SongDTO>> getByBand (@RequestParam("band-name")String bandName) {
        return new ResponseEntity<>(songService.songsByBand(bandName).stream().map(songMapper::toDto).collect(Collectors.toList())
        ,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getByGenre (@RequestParam Genre genre) {
        return new ResponseEntity<>(songService.songsByGenre(genre).stream().map(songMapper::toDto).collect(Collectors.toList()),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SongDTO> getById(@RequestParam("id") Long id){
        return new ResponseEntity<>(songService.)
    }

    @PostMapping
    public ResponseEntity<SongDTO> saveSong (@RequestParam SongDTO songDTO){
        return new ResponseEntity<SongDTO>(songMapper.toDto(songService.saveSong(songMapper.toEntity(songDTO))),HttpStatus.CREATED);
    }





}
