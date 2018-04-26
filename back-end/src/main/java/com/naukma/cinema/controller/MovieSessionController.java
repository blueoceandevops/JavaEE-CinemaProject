package com.naukma.cinema.controller;

import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.service.MovieSessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieSessionController {

    private final MovieSessionService movieSessionService;

    public MovieSessionController(MovieSessionService movieSessionService) {
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("{id}/today")
    public List<MovieSession> getAllParticularMovieSessionsForToday(@PathVariable Integer id) {
        return movieSessionService.getAllMovieSessionsForTodayByMovieId(id);
    }

    @GetMapping("all/today")
    public List<MovieSession> getAllMovieSessionsForToday() {
        return movieSessionService.getAllMovieSessionsForToday();
    }

    @GetMapping("{id}")
    public MovieSession getById(@PathVariable Integer id) {
        return movieSessionService.getById(id);
    }

    @GetMapping("{id}/{day}")
    public List<MovieSession> findAllMovieSessionsByDayAndMovieIds(@PathVariable Date day, @PathVariable Integer id) {
        return movieSessionService.getAllMovieSessionsByDayAndMovieId(day, id);
    }

    @GetMapping("{day}")
    public List<MovieSession> getByDay(@PathVariable Date day) {
        return movieSessionService.findAllMovieSessionsByDay(day);
    }
}
