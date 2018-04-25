package com.repository;

import com.domain.OccupiedSeat;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OccupiedSeatRepository extends CrudRepository<OccupiedSeat, Integer> {

    Optional<OccupiedSeat> findOccupiedSeatByRowAndSeatAndMovieSessionId(Integer row, Integer seat,
                                                                         Integer movieSessionId);
}
