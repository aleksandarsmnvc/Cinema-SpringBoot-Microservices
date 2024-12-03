package com.aleksandar_simeunovic.movie_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShortMovieDTO {
    private String name;
    private String cover_image;
}
