package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.dto.CinemaDTO;
import com.aleksandar.cinema_service.model.Cinema;
import com.aleksandar.cinema_service.repository.CinemaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public Cinema getCinema(int id)throws EntityNotFoundException{
        return cinemaRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Cinema not found with id:"+id));
    }

    public List<Cinema> getAllCinema(){
        return cinemaRepository.findAll();
    }

    public void addCinema(CinemaDTO cinemaDTO){
        cinemaRepository.save(Cinema.builder()
                .name(cinemaDTO.getName())
                .cover_image(cinemaDTO.getCover_image())
                .description(cinemaDTO.getDescription())
                .city(cinemaDTO.getCity())
                .country(cinemaDTO.getCountry())
                .build());
    }
}
