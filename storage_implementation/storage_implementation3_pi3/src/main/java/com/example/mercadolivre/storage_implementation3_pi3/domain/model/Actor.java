package com.example.mercadolivre.storage_implementation3_pi3.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String first_name;
    private String last_name;
    private Double rating;

    @ManyToMany
    @JoinTable(
            name = "actor_movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "actor_episode",
            joinColumns = @JoinColumn(name = "actor_id")
    )
    private Set<Episode> episodes = new HashSet<>();

}
