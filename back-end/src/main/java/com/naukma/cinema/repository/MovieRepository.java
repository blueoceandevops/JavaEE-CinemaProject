package com.naukma.cinema.repository;

import com.naukma.cinema.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    @Query("FROM Movie m " +
            "WHERE m.cinemaReleaseDate >= current_date " +
            "AND m.cinemaReleaseEndDate <= current_date")
    List<Movie> findAllRunningMovies();
}
