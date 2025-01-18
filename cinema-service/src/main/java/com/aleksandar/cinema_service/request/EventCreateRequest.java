package com.aleksandar.cinema_service.request;

import jakarta.validation.constraints.NotBlank;

import java.time.Duration;
import java.util.Date;

public class EventCreateRequest {
    @NotBlank
    private int cinema_id;
    @NotBlank
    private int movie_id;
    @NotBlank
    private Date date;
    @NotBlank
    private Duration duration;
}
