package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/today")
    public List<Movie> getAllRunningMovies() {
        return movieService.getAllRunningMovies();
    }

    @GetMapping("/soon")
    public List<Movie> getAllFutureMovies() {
        return movieService.getAllFutureMovies();
    }


}
