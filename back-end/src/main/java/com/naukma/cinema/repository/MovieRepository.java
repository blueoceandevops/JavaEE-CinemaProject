package com.naukma.cinema.repository;

import com.naukma.cinema.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

   @Query("FROM Movie m " +
            "WHERE m.cinemaReleaseDate <= current_date " +
            "AND m.cinemaReleaseEndDate >= current_date")
    List<Movie> findAllRunningMovies();
    
    @Query("FROM Movie m " +
            "WHERE m.cinemaReleaseDate > current_date ")
    List<Movie> findAllFutureMovies();

    @Query("FROM Movie m " +
            "WHERE m.cinemaReleaseDate <= (:day) AND m.cinemaReleaseEndDate >= (:day)")
    List<Movie> findAllMoviesByDay(@Param("day") Date day);
    
}