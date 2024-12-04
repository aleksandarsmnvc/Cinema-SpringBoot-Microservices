package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.dto.MovieDTO;
import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public Movie getMovie(int id) throws EntityNotFoundException{
        return repository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Movie not found with id:"+id));
    }

    public List<Movie> getAllMovies(){
        return repository.findAll();
    }

    public void addMovie(MovieDTO movieDTO){
        repository.save(Movie.builder()
                .name(movieDTO.getName())
                .cover_image(movieDTO.getCover_image())
                .description(movieDTO.getDescription())
                .director(movieDTO.getDirector())
                .trailer(movieDTO.getTrailer())
                .build());
    }

}
