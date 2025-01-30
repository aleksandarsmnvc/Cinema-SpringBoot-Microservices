package com.aleksandar.cinema_service.controller;

import com.aleksandar.cinema_service.dto.EventDTO;
import com.aleksandar.cinema_service.dto.MovieDTO;
import com.aleksandar.cinema_service.dto.ShortEventDTO;
import com.aleksandar.cinema_service.dto.ShortMovieDTO;
import com.aleksandar.cinema_service.model.Event;
import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.request.EventCreateRequest;
import com.aleksandar.cinema_service.request.MovieCreateRequest;
import com.aleksandar.cinema_service.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {
    @Autowired
    private final EventService eventService;
    @Autowired
    private final ModelMapper mapper;
    @GetMapping("/{id}")
    public ResponseEntity<EventDTO> getEvent(@PathVariable int id) throws Exception{
        Event event = eventService.getEvent(id);
        return ResponseEntity.ok(mapper.map(event,EventDTO.class));
    }
    @GetMapping("")
    public ResponseEntity<List<ShortEventDTO>> getAllEvents(){
        return ResponseEntity.ok(eventService.getAllEvents().stream()
                .map(event -> mapper.map(event,ShortEventDTO.class)).toList());
    }
    @PostMapping("")
    public ResponseEntity<?> createEvent(EventCreateRequest request){
        eventService.addEvent(request);
        return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
    }
}
