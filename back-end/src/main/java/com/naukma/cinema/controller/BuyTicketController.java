package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BuyTicketController {

    @Autowired
    private MovieSessionService movieSessionService;

    @RequestMapping(value = "/buy-ticket")
    public String about(@RequestParam(value = "id") Integer id, Map<String, Object> model)
    {
        MovieSession currentMovieSession = movieSessionService.getById(id);
        String title = currentMovieSession.getMovie().getTitle();
        model.put("currentMovieSession", currentMovieSession);
        model.put("title", title);
        return "buy-ticket";
    }
}
