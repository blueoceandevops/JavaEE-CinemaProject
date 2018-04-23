package com.naukma.cinema.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class AvailableMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(

            name = "movie_seq",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    private Integer id;
    @OneToMany(mappedBy = "avMovie")
    private List <Movie> movies;

    public Integer getId() {
        return id;
    }


    @Override
    public int hashCode() {

        return Objects.hash(id, movies);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }


}
