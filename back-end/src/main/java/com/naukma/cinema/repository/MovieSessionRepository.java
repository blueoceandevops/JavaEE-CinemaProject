package com.naukma.cinema.repository;

import com.naukma.cinema.domain.MovieSession;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface MovieSessionRepository extends CrudRepository<MovieSession, Integer> {

    @Query("FROM MovieSession s " +
            "WHERE s.movie.id = (:id) AND CAST(s.startDateTime AS date) = current_date")
    List<MovieSession> findAllMovieSessionsForTodayByMovieId(@Param("id") Integer id);

    @Query("FROM MovieSession s " +
            "WHERE CAST(s.startDateTime AS date) = current_date " +
            "AND s.movie.id IN (:ids)")
    List<MovieSession> findAllMovieSessionsForTodayByMovieIds(@Param("ids") Set<Integer> ids);

    @Query("FROM MovieSession s " +
            "WHERE CAST(s.startDateTime AS date) = (:day) " +
            "AND s.movie.id = (:id)")
    List<MovieSession> findAllMovieSessionsByDayAndMovieId(@Param("day")Date day, @Param("id")Integer id);

    @Query("FROM MovieSession s " +
            "WHERE CAST(s.startDateTime AS date) = (:day) ")
    List<MovieSession> findAllMovieSessionsByDay(Date day);
}
