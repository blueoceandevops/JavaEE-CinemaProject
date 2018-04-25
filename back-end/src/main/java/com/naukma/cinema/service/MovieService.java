package com.naukma.cinema.service;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllRunningMovies() {
        return movieRepository.findAllRunningMovies();
    }
}
