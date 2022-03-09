package com.songexpert.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BandDTO {
    String name;
    LocalDate creatingDate;
    List<MusicianDTO> musicians;
}
