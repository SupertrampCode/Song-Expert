package com.songexpert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "musicians")
@Entity
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name",nullable = false)
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name ="birthday")
    private LocalDate birthday;

    @Column(name="biography")
    private String biography;

    @ManyToOne(targetEntity = Band.class)
    @JoinColumn(name = "band_id")
    private Band band;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musician musician = (Musician) o;
        return id != null && Objects.equals(id, musician.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
