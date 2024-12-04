package com.aleksandar.cinema_service.mappers;

import com.aleksandar.cinema_service.dto.CinemaDTO;
import com.aleksandar.cinema_service.dto.ShortCinemaDTO;
import com.aleksandar.cinema_service.model.Cinema;
import org.springframework.stereotype.Component;

@Component
public class CinemaMapper {

    public static ShortCinemaDTO toShortCinemaDTO(Cinema cinema){
        return new ShortCinemaDTO(cinema.getName(), cinema.getCover_image());
    }

    public static CinemaDTO toCinemaDTO(Cinema cinema){
        return new CinemaDTO(cinema.getName(), cinema.getCover_image(), cinema.getDescription()
                ,cinema.getCity(), cinema.getCountry());
    }
}
