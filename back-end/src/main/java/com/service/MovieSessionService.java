package com.service;

import com.domain.Movie;
import com.domain.MovieSession;
import com.repository.MovieSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;
import static org.hibernate.validator.internal.util.CollectionHelper.newHashSet;

@Service
public class MovieSessionService {

    private final MovieSessionRepository repository;
    private final MovieService movieService;

    public MovieSessionService(MovieSessionRepository repository, MovieService movieService) {
        this.repository = repository;
        this.movieService = movieService;
    }

    public List<MovieSession> getAllMovieSessionsForTodayByMovieId(Integer id) {
        requireNonNull(id);
        return repository.findAllMovieSessionsForTodayByMovieIds(newHashSet(id));
    }

    public List<MovieSession> getAllMovieSessionsForToday() {
        Set<Integer> runningMoviesIds = movieService.getAllRunningMovies().stream()
                .map(Movie::getId)
                .collect(toSet());
        if (runningMoviesIds.isEmpty()) {
            return emptyList();
        }
        return repository.findAllMovieSessionsForTodayByMovieIds(runningMoviesIds);
    }

    public MovieSession getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No movie session with id = " + id));
    }
}