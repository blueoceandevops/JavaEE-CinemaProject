package com.naukma.cinema.service;

import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.domain.OccupiedSeat;
import com.naukma.cinema.domain.Ticket;
import com.naukma.cinema.repository.TicketRepository;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.Integer.parseInt;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final MovieSessionService movieSessionService;
    private final OccupiedSeatService occupiedSeatService;
    private final TicketGenerator ticketGenerator;

    public TicketService(TicketRepository ticketRepository, MovieSessionService movieSessionService,
                         OccupiedSeatService occupiedSeatService, TicketGenerator ticketGenerator) {
        this.ticketRepository = ticketRepository;
        this.movieSessionService = movieSessionService;
        this.occupiedSeatService = occupiedSeatService;
        this.ticketGenerator = ticketGenerator;
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

    public ByteArrayInputStream print(String id) throws Exception {
        validateNumericParam(id);
        Ticket ticket = ticketRepository.findById(parseInt(id))
                .orElseThrow(() -> new IllegalArgumentException("No ticket with such id"));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        String generatedTicket = ticketGenerator.createTicket(ticket);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(generatedTicket);
        renderer.layout();
        renderer.createPDF(outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    /*Check if values are appropriate (using ValueHandlerFactory class)*/
    private void validateBuyParams(String sessionId, String row, String place) {
        validateNumericParam(sessionId);
        validateNumericParam(row);
        validateNumericParam(place);
    }

    private void validateNumericParam(String param) {
        if (!isNumeric(param)) {
            throw new IllegalArgumentException();
        }
    }

}
