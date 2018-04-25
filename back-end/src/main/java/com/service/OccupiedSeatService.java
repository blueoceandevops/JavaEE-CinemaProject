package com.service;

import com.domain.MovieSession;
import com.domain.OccupiedSeat;
import com.repository.OccupiedSeatRepository;
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
