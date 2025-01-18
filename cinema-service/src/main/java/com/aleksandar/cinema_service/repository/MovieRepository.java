package com.aleksandar.cinema_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aleksandar.cinema_service.model.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
