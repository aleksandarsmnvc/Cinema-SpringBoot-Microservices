package com.aleksandar.cinema_service.repository;

import com.aleksandar.cinema_service.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Integer> {
}
