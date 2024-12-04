package com.aleksandar.cinema_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CinemaDTO extends ShortCinemaDTO{
    private String description;
    private String city;
    private String country;

    public CinemaDTO(String name,String cover_image,String description,String city,String country){
        super(name,cover_image);
        this.description=description;
        this.city=city;
        this.country=country;
    }
}
