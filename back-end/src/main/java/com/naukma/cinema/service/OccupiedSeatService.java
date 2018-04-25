package com.naukma.cinema.service;

import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.domain.OccupiedSeat;
import com.naukma.cinema.repository.OccupiedSeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OccupiedSeatService {

    private final OccupiedSeatRepository repository;

    public OccupiedSeatService(OccupiedSeatRepository repository) {
        this.repository = repository;
    }

    /*Creating new instance of OccupiedSeat class and setting parameters. Saving a seat to repository */
    @Transactional
    public OccupiedSeat createIfNotExists(Integer row, Integer seat, MovieSession movieSession) {
        OccupiedSeat occupiedSeat = new OccupiedSeat();
        occupiedSeat.setRow(row);
        occupiedSeat.setSeat(seat);
        occupiedSeat.setMovieSession(movieSession);
        return repository.save(occupiedSeat);
    }
}
