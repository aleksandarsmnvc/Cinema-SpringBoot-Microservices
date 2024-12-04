package com.aleksandar.cinema_service.model;

import com.aleksandar.cinema_service.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int movie_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String cover_image;
    @Column
    private String trailer;
    @Column
    private String director;

}

