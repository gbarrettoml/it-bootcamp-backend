package com.example.mercadolivre.storage_implementation3_pi3.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private OffsetDateTime release_date;
    private OffsetDateTime end_date;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
