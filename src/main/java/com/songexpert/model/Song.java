package com.songexpert.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "info", columnDefinition = "TEXT")
    private String info;

    @Column(name = "created")
    private LocalDate created;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "uploaded")
    private Date updated;

}
