package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Ticket;
import com.naukma.cinema.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("session/{sessionId}/row/{row}/place/{place}")
    public Ticket buy(@PathVariable String sessionId,
                      @PathVariable String row,
                      @PathVariable String place) {
        return ticketService.buy(sessionId, row, place);
    }
}
