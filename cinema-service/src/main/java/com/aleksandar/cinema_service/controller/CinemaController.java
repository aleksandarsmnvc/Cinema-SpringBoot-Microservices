package com.aleksandar.cinema_service.controller;

import com.aleksandar.cinema_service.dto.CinemaDTO;
import com.aleksandar.cinema_service.dto.MovieDTO;
import com.aleksandar.cinema_service.dto.ShortCinemaDTO;
import com.aleksandar.cinema_service.mappers.CinemaMapper;
import com.aleksandar.cinema_service.model.Cinema;
import com.aleksandar.cinema_service.request.CinemaCreateRequest;
import com.aleksandar.cinema_service.service.CinemaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/cinema")
@RequiredArgsConstructor
public class CinemaController {
    @Autowired
    private final CinemaService cinemaService;
    @Autowired
    private final ModelMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<CinemaDTO>getCinema(@PathVariable int id)throws Exception{
        Cinema cinema=cinemaService.getCinema(id);
        return ResponseEntity.ok(mapper.map(cinema,CinemaDTO.class));
    }

    @GetMapping("")
    public ResponseEntity<List<ShortCinemaDTO>> getAllCinema(){
        return ResponseEntity.ok(cinemaService.getAllCinema().stream()
                .map(cinema -> mapper.map(cinema,ShortCinemaDTO.class)).toList());
    }

    @PostMapping("")
    public ResponseEntity<?> createCinema(@Valid @RequestPart CinemaCreateRequest request,
                                          @RequestPart(required = false)MultipartFile cover_file){
        cinemaService.addCinema(request,cover_file);
        return ResponseEntity.ok("Successfully created Cinema instance!");
    }
}
