package com.songexpert.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class SongDTO {
    Long id;
    String name;
    GenreDTO genre;
    BandDTO band;
    int duration;
    String link;
}
