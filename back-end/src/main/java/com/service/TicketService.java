package com.service;

import com.domain.MovieSession;
import com.domain.OccupiedSeat;
import com.domain.Ticket;
import com.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.lang.Integer.parseInt;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final MovieSessionService movieSessionService;
    private final OccupiedSeatService occupiedSeatService;

    public TicketService(TicketRepository ticketRepository, MovieSessionService movieSessionService,
                         OccupiedSeatService occupiedSeatService) {
        this.ticketRepository = ticketRepository;
        this.movieSessionService = movieSessionService;
        this.occupiedSeatService = occupiedSeatService;
    }

    @Transactional
    public Ticket buy(String sessionId, String row, String place) {
        validateBuyParams(sessionId, row, place);
        MovieSession movieSession = movieSessionService.getById(parseInt(sessionId));
        Ticket ticket = new Ticket();
        ticket.setMovieSession(movieSession);
        OccupiedSeat seat = occupiedSeatService.createIfNotExists(parseInt(row), parseInt(place), movieSession);
        ticket.setOccupiedSeat(seat);
        return ticketRepository.save(ticket);
    }
/*Check if values are appropriate (using ValueHandlerFactory class)*/
    private void validateBuyParams(String sessionId, String row, String place) {
        if (!isNumeric(sessionId) || !isNumeric(row) || !isNumeric(place)) {
            throw new IllegalArgumentException();
        }
    }
}
