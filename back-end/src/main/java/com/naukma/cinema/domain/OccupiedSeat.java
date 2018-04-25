package com.naukma.cinema.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OccupiedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "occupied_seat_seq")
    @SequenceGenerator(
            name = "occupied_seat_seq",
            sequenceName = "occupied_seat_sequence",
            allocationSize = 1
    )
    private Integer id;

    private Integer row;

    private Integer seat;

    @ManyToOne
    private MovieSession movieSession;

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}