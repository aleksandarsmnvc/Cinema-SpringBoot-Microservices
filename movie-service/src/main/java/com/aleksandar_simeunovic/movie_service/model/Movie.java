package com.aleksandar_simeunovic.movie_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

