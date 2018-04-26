package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AboutMovieController {

    @Autowired
    private MovieSessionService movieSessionService;

    @RequestMapping(value = "/about-movie")
    public String about(@RequestParam(value = "id") Integer id, Map<String, Object> model)
    {
        System.out.println(id);
        List<MovieSession> currentMovieSession = movieSessionService.getAllMovieSessionsForTodayByMovieId(id);
        for(MovieSession movieSession: currentMovieSession){
            System.out.println(movieSession.getMovie().getId() + movieSession.getMovie().getTitle());
        }
        if(currentMovieSession.size() > 0){
            Movie currentMovie = currentMovieSession.get(0).getMovie();
            model.put("currentMovie", currentMovie);
        }
        model.put("currentMovieSession", currentMovieSession);
        return "about-movie";
    }

}
