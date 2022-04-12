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
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private Integer ranking;
    private Integer active;

    @OneToMany(
            mappedBy = "genre",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Movie> movies = new HashSet<>();

    @OneToMany(
            mappedBy = "genre",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Serie> series = new HashSet<>();

}
