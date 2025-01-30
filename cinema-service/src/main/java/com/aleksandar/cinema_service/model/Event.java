package com.aleksandar.cinema_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Cinema cinema;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Duration duration;
}
