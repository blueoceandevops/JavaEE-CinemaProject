package com.naukma.cinema.domain;

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

    private String moviePosterLink;

    private String movieTrailerLink;

    private Double movieRating;

    private Integer ageRestriction;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getMoviePosterLink() {
        return moviePosterLink;
    }

    public void setMoviePosterLink(String moviePosterLink) {
        this.moviePosterLink = moviePosterLink;
    }

    public String getMovieTrailerLink() {
        return movieTrailerLink;
    }

    public void setMovieTrailerLink(String movieTrailerLink) {
        this.movieTrailerLink = movieTrailerLink;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }

    public Integer getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Integer ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return duration == movie.duration &&
                Objects.equals(title, movie.title) &&
                Objects.equals(originalTitle, movie.originalTitle) &&
                Objects.equals(movieRating, movie.movieRating) &&
                Objects.equals(ageRestriction, movie.ageRestriction) &&
                Objects.equals(genres, movie.genres) &&
                Objects.equals(releaseDate, movie.releaseDate) &&
                Objects.equals(cinemaReleaseDate, movie.cinemaReleaseDate) &&
                Objects.equals(cinemaReleaseEndDate, movie.cinemaReleaseEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, originalTitle, movieRating, ageRestriction, genres, duration, releaseDate,
                cinemaReleaseDate, cinemaReleaseEndDate);
    }
}