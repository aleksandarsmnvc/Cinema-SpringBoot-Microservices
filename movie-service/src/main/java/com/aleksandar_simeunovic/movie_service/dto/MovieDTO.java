package com.aleksandar_simeunovic.movie_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO extends ShortMovieDTO {
    private String description;
    private String director;
    private String trailer;
    public MovieDTO(String name,String cover_image,String description,String director,String trailer){
        super(name,cover_image);
        this.description=description;
        this.director=director;
        this.trailer=trailer;
    }
}
