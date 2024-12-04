package com.aleksandar.cinema_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cinema {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int cinema_id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String cover_image;
    @Column
    private String city;
    @Column
    private String country;
}
