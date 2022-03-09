package com.songexpert.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MusicianDTO {
    String firstName;
    String lastName;
    LocalDate birthday;
    String biography;
    BandDTO band;
}
