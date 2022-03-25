package com.songexpert.controllers;


import com.songexpert.dto.SongDTO;
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


    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll() {
        return new ResponseEntity<>(songService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public SongDTO get(@PathVariable("id") Long id) {
        return songService.findById(id);
    }

    @GetMapping("name-search")
    public ResponseEntity<List<SongDTO>> getByName(@RequestParam("name") String name) {
        return new ResponseEntity<>(songService.findByName(name),
                HttpStatus.OK);
    }

    @GetMapping("band-search")
    public ResponseEntity<List<SongDTO>> getByBand(@RequestParam("band-name") String bandName) {
        return new ResponseEntity<>(songService.songsByBand(bandName),
                HttpStatus.OK);
    }

    @GetMapping("genre-search")
    public ResponseEntity<List<SongDTO>> getByGenre(@RequestParam("genre-name") String genreName) {
        return new ResponseEntity<>(songService.songsByGenre(genreName),
                HttpStatus.OK);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") Long id, @RequestBody SongDTO songDTO) {
        if (!id.equals(songDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        songService.update(songDTO);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<SongDTO> saveSong(@RequestParam SongDTO songDTO) {
        return new ResponseEntity<>(songService.saveSong(songDTO),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        songService.delete(id);
        return HttpStatus.OK;
    }
}
