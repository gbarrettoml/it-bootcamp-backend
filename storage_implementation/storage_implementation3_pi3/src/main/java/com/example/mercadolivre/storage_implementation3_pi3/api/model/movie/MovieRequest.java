package com.example.mercadolivre.storage_implementation3_pi3.api.model.movie;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MovieRequest {

    private Integer Id;
    private String title;
    private Double rating;
    private Integer awards;
    private OffsetDateTime release_date;
    private Integer length;
    private MovieGenreReqRes genre;
    private Set<MovieActorReqRes> actors = new HashSet<>();
}
