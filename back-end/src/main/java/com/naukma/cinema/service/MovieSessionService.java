package com.naukma.cinema.service;

import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.repository.MovieSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSessionService {
    public MovieSessionService() {
    }

    public MovieSessionRepository getRepository() {
        return repository;
    }

    private MovieSessionRepository repository;

    public List<MovieSession> getAllMovieSessionsForTodayByMovieId(Integer id) {
        return repository.findAllMovieSessionsForTodayByMovieId(id);
    }

    public List<MovieSession> getAllMovieSessionsForToday() {
        return repository.findAllMovieSessionsForToday();
    }
}
