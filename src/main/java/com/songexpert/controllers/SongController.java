package com.songexpert.controllers;


import com.songexpert.dto.SongDTO;
import com.songexpert.mappers.SongMapper;
import com.songexpert.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SongController {

    private final SongService songService;
    private final SongMapper songMapper;


    public SongController(SongService songService, SongMapper songMapper) {
        this.songService = songService;
        this.songMapper = songMapper;
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        return new ResponseEntity<>(songMapper.toDtoList(songService.getAll()),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SongDTO get(@PathVariable("id") Long id) {
        return songMapper.toDto(songService.getSong(id));
    }

    @GetMapping("name-search")
    public ResponseEntity<List<SongDTO>> getByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(songMapper.toDtoList(songService.findByName(name)),
                HttpStatus.OK);
    }

    @GetMapping("band-search")
    public ResponseEntity<List<SongDTO>> getByBand(@RequestParam("band-name") String bandName) {
        return new ResponseEntity<>(songMapper.toDtoList(songService.songsByBand(bandName)),
                HttpStatus.OK);
    }

    @GetMapping("genre-search")
    public ResponseEntity<List<SongDTO>> getByGenre(@RequestParam("genre-name") String genreName) {
        return new ResponseEntity<>(songMapper.toDtoList(songService.songsByGenre(genreName)),
                HttpStatus.OK);
    }


    @PostMapping("save")
    public ResponseEntity<SongDTO> saveSong(@RequestParam SongDTO songDTO) {
        return new ResponseEntity<>(songMapper.toDto(songService.saveSong(songMapper.toEntity(songDTO))),
                HttpStatus.CREATED);
    }

}
