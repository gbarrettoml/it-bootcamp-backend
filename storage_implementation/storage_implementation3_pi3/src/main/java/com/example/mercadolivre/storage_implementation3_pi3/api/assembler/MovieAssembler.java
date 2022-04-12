package com.example.mercadolivre.storage_implementation3_pi3.api.assembler;

import com.example.mercadolivre.storage_implementation3_pi3.api.model.movie.MovieRequest;
import com.example.mercadolivre.storage_implementation3_pi3.api.model.movie.MovieResponse;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Movie;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MovieAssembler {

    private ModelMapper modelMapper;

    public Movie toDomainObject(MovieRequest movieRequest) {
        return modelMapper.map(movieRequest, Movie.class);
    }

    public MovieResponse toResponseObject(Movie entity) {
        return modelMapper.map(entity, MovieResponse.class);
    }
}
