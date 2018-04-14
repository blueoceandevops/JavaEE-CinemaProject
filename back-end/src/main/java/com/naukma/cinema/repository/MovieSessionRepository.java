package com.naukma.cinema.repository;

import com.naukma.cinema.domain.MovieSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieSessionRepository extends CrudRepository<MovieSession, Integer> {

    @Query("FROM MovieSession s " +
            "WHERE CAST(s.startDateTime AS date) = current_date " +
            "AND s.movie.id = :id")
    List<MovieSession> findAllMovieSessionsForTodayByMovieId(@Param("id") Integer id);

    @Query("FROM MovieSession s " +
            "WHERE CAST(s.startDateTime AS date) = current_date")
    List<MovieSession> findAllMovieSessionsForToday();
}
