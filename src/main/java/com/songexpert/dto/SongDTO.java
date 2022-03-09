package com.songexpert.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongDTO {
    String name;
    GenreDTO genre;
    BandDTO band;
    int duration;
    String link;
}
