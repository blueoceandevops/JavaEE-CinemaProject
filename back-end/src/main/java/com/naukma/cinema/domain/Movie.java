package com.naukma.cinema.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(

            name = "movie_seq",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    private Integer id;

    private String title;

    private String originalTitle;

    public Movie() {
    }

    @ManyToMany
    @JoinTable(
            name = "movie_map_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_type")
    )
    private List<Genre> genres;

    private int duration;

    private Date releaseDate;

    private Date cinemaReleaseDate;

    private Date cinemaReleaseEndDate;
    public Integer getId() {
        return id;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Movie movie = (Movie) object;
        return duration == movie.duration &&
                java.util.Objects.equals(title, movie.title) &&
                java.util.Objects.equals(originalTitle, movie.originalTitle) &&
                java.util.Objects.equals(genres, movie.genres) &&
                java.util.Objects.equals(releaseDate, movie.releaseDate) &&
                java.util.Objects.equals(cinemaReleaseDate, movie.cinemaReleaseDate) &&
                java.util.Objects.equals(cinemaReleaseEndDate, movie.cinemaReleaseEndDate);
    }

    public int hashCode() {

        return Objects.hash(super.hashCode(), title, originalTitle, genres, duration, releaseDate, cinemaReleaseDate, cinemaReleaseEndDate);
    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Date getCinemaReleaseDate() {
        return cinemaReleaseDate;
    }

    public void setCinemaReleaseDate(Date cinemaReleaseDate) {
        this.cinemaReleaseDate = cinemaReleaseDate;
    }

    public Date getCinemaReleaseEndDate() {
        return cinemaReleaseEndDate;
    }

    public void setCinemaReleaseEndDate(Date cinemaReleaseEndDate) {
        this.cinemaReleaseEndDate = cinemaReleaseEndDate;
    }

}