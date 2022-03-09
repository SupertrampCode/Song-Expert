package com.songexpert.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;


/**
 * Duration in secs.
 */

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(targetEntity = Band.class)
    @JoinColumn(name = "band_id")
    private Band band;

    @Column(name = "duration")
    private int duration;

    @Column(name = "link")
    private String link;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id != null && Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
