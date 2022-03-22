package com.songexpert.controllers;

import com.songexpert.dto.GenreDTO;
import com.songexpert.exceptions.ElementAlreadyExistException;
import com.songexpert.mappers.GenreMapper;
import com.songexpert.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GenreController {
    private final GenreMapper genreMapper;
    private final GenreService genreService;

    @Autowired
    public GenreController(GenreMapper genreMapper, GenreService genreService) {
        this.genreMapper = genreMapper;
        this.genreService = genreService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(genreMapper.toDto(genreService.getById(id)), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<GenreDTO>> getAll() {
        return new ResponseEntity<>(genreMapper.toDtoList(genreService.getAll()), HttpStatus.OK);
    }

    //TODO throw exception ElementAlreadyExist
    @PostMapping
    public ResponseEntity<GenreDTO> create(@RequestBody GenreDTO genreDTO) throws ElementAlreadyExistException {
        genreService.checkIdentity(genreMapper.toEntity(genreDTO));
        return new ResponseEntity<>(genreMapper.toDto(genreService.save(genreMapper.toEntity(genreDTO))), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody GenreDTO genreDTO) {
        if (!id.equals(genreDTO.getId())) {
            throw new IllegalArgumentException("ID's don't match");
        }
        genreService.update(genreMapper.toEntity(genreDTO));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") Long id) {
        genreService.delete(genreService.getById(id));
        return HttpStatus.OK;
    }

}
