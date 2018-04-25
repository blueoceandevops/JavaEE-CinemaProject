package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Ticket;
import com.naukma.cinema.service.TicketService;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

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

    @GetMapping(value = "/{id}/printed")
    public ResponseEntity<InputStreamResource> print(@PathVariable String id) throws Exception {
        ByteArrayInputStream outputStream = ticketService.print(id);
        return ok()
                .header("Content-Disposition", "inline; filename=ticket.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(outputStream));
    }
}
