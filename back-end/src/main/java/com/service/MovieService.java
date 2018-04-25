package com.service;

import com.domain.Movie;
import com.repository.MovieRepository;
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
