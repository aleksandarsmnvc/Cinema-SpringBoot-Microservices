package com.aleksandar.cinema_service.controller;

import com.aleksandar.cinema_service.dto.MovieDTO;
import com.aleksandar.cinema_service.dto.ShortMovieDTO;
import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.request.MovieCreateRequest;
import com.aleksandar.cinema_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private final MovieService service;
    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable int id) throws Exception{
        Movie movie = service.getMovie(id);
        return ResponseEntity.ok(mapper.map(movie,MovieDTO.class));
    }
    @GetMapping("")
    public ResponseEntity<List<ShortMovieDTO>> getAllMovies(){
        return ResponseEntity.ok(service.getAllMovies().stream()
                .map(movie -> mapper.map(movie,ShortMovieDTO.class)).toList());
    }

    @PostMapping("")
    public ResponseEntity<?> createMovie(MovieCreateRequest request, MultipartFile movie_file){
        service.addMovie(request,movie_file);
        return new ResponseEntity<>("Successfully created",HttpStatus.CREATED);
    }
}
