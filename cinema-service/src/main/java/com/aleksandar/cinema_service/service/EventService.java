package com.aleksandar.cinema_service.service;

import com.aleksandar.cinema_service.model.Event;
import com.aleksandar.cinema_service.repository.EventRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public Event getEvent(int id)throws EntityNotFoundException {
        return eventRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Entity not found with id:"+id));
    }

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    //public void addEvent(int movie_id,int cinema_id,)
}
