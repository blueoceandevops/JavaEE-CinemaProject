package com.naukma.cinema.repository;

import com.naukma.cinema.domain.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
    @Query("FROM Movie m " +
            "WHERE m.movie.id = :id")
    List<Movie> findAllMoviesByMovieId(@Param("id") Integer id);

}
