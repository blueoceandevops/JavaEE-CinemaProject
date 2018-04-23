package com.naukma.cinema.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MovieSession {

    @Id
    private Integer id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Hall hall;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public List<OccupiedSeat> getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(List<OccupiedSeat> occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    @ManyToMany
    @JoinTable(
            name = "movie_session_map_occupied_seat",
            joinColumns = @JoinColumn(name = "movie_session_id"),
            inverseJoinColumns = @JoinColumn(name = "occupied_seat_id")

    )
    private List<OccupiedSeat> occupiedSeats;

    private LocalDateTime startDateTime;
}