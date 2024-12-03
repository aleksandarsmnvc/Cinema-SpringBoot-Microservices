package com.aleksandar_simeunovic.movie_service.mapper;

import com.aleksandar_simeunovic.movie_service.dto.MovieDTO;
import com.aleksandar_simeunovic.movie_service.dto.ShortMovieDTO;
import com.aleksandar_simeunovic.movie_service.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public static ShortMovieDTO toShortMovieDTO(Movie movie){
        return new ShortMovieDTO(movie.getName(), movie.getCover_image());
    }

    public static MovieDTO toMovieDTO(Movie movie){
        return new MovieDTO(movie.getName(), movie.getCover_image() , movie.getDescription(), movie.getDirector(), movie.getTrailer());
    }
}
