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
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private Integer number;
    private OffsetDateTime release_date;
    private OffsetDateTime end_date;

    @OneToMany(
            mappedBy = "season",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Episode> episodes = new HashSet<>();
}
