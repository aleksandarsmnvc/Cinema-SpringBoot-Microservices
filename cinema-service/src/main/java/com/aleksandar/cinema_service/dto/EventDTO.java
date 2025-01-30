package com.aleksandar.cinema_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    MovieDTO movieDTO;
    CinemaDTO cinemaDTO;
    Date date;
    Duration duration;

}
