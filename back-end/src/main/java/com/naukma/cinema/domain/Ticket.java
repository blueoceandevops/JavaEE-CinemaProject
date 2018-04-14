package com.naukma.cinema.domain;

import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(
            name = "ticket_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    private MovieSession movieSession;

    @OneToOne
    private User user;

    @OneToOne
    private OccupiedSeat occupiedSeat;

    private LocalDateTime sellTime;

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Ticket ticket = (Ticket) object;
        return java.util.Objects.equals(movieSession, ticket.movieSession) &&
                java.util.Objects.equals(user, ticket.user) &&
                java.util.Objects.equals(occupiedSeat, ticket.occupiedSeat) &&
                java.util.Objects.equals(sellTime, ticket.sellTime);
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), movieSession, user, occupiedSeat, sellTime);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MovieSession getMovieSession() {
        return movieSession;
    }

    public void setMovieSession(MovieSession movieSession) {
        this.movieSession = movieSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OccupiedSeat getOccupiedSeat() {
        return occupiedSeat;
    }

    public void setOccupiedSeat(OccupiedSeat occupiedSeat) {
        this.occupiedSeat = occupiedSeat;
    }

    public LocalDateTime getSellTime() {
        return sellTime;
    }

    public void setSellTime(LocalDateTime sellTime) {
        this.sellTime = sellTime;
    }

}