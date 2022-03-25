package com.songexpert.controllers;

import com.songexpert.dto.GenreDTO;
import com.songexpert.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenreDTO>> getAll() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreDTO genreDTO) {
        return new ResponseEntity<>(genreService.save(genreDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody GenreDTO genreDTO) {
        if (!id.equals(genreDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        genreService.update(genreDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        genreService.delete(id);
        return HttpStatus.OK;
    }
}
