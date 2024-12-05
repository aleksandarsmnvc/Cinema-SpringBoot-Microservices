package com.aleksandar.cinema_service.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaCreateRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String city;
    @NotBlank
    private String country;
}
