package com.aleksandar_simeunovic.movie_service.repository;

import com.aleksandar_simeunovic.movie_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
