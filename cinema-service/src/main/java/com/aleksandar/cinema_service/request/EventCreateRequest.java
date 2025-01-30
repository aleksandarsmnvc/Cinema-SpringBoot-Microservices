package com.aleksandar.cinema_service.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
