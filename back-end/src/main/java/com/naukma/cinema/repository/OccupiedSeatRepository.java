package com.naukma.cinema.repository;

import com.naukma.cinema.domain.OccupiedSeat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OccupiedSeatRepository extends CrudRepository<OccupiedSeat, Integer> {
    @Query("FROM OccupiedSeat os " +
            "WHERE os.movieSession.id = (:movieSessionId)")
    List<OccupiedSeat> findOccupiedSeatBySessionId(@Param("movieSessionId")Integer movieSessionId);
}
