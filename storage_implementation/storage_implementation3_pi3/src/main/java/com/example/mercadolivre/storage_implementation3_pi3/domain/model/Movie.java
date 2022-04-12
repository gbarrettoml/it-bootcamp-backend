package com.example.mercadolivre.storage_implementation3_pi3.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private Double rating;
    private Integer awards;
    private OffsetDateTime release_data;
    private Integer length;

    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(
            mappedBy = "movies",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Actor> actors = new HashSet<>();

}
