package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.model.Cinema;
import com.aleksandar.cinema_service.model.Event;
import com.aleksandar.cinema_service.model.Movie;
import com.aleksandar.cinema_service.repository.CinemaRepository;
import com.aleksandar.cinema_service.repository.EventRepository;
import com.aleksandar.cinema_service.repository.MovieRepository;
import com.aleksandar.cinema_service.request.EventCreateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private final EventRepository eventRepository;
    @Autowired
    private final MovieRepository movieRepository;
    @Autowired
    private final CinemaRepository cinemaRepository;

    public Event getEvent(int id)throws EntityNotFoundException {
        return eventRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Entity not found with id:"+id));
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public void addEvent(EventCreateRequest request){
        Optional<Movie> movie=movieRepository.findById(request.getMovie_id());
        Optional<Cinema> cinema=cinemaRepository.findById(request.getCinema_id());

        if(movie.isPresent()&& cinema.isPresent()){
            eventRepository.save(Event.builder()
                    .cinema(cinema.get())
                    .movie(movie.get())
                    .date(request.getDate())
                    .duration(request.getDuration())
                    .build());
        }
        else throw new EntityNotFoundException("Either Cinema or Movie id doesn't exists!");
    }
}
