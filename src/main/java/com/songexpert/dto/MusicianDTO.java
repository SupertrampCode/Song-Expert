package com.songexpert.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class MusicianDTO {
    Long id;
    String firstName;
    String lastName;
    LocalDate birthday;
    String biography;
    BandDTO band;
}
