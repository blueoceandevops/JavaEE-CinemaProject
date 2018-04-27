package com.naukma.cinema.controller;
import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;
    private List<Movie> movies;

    @RequestMapping(value = "/soon")
    public String soon(Map<String, Object> model){
        List<Movie> moviesSoon = movieService.getAllFutureMovies();
        model.put("moviesSoon", moviesSoon);
        return "soon";
    }

    @RequestMapping(value = "/about-us")
    public String aboutUs()
    {
        return "about-us";
    }

    @RequestMapping(value = "/by-film")
    public String byFilm(Map<String, Object> model){
        movies = movieService.getAllRunningMovies();
        model.put("movies", movies);
        return "index";
    }

    @RequestMapping(value = "/")
    public String main(Map<String, Object> model){
        if(movies == null) {
            movies = movieService.getAllRunningMovies();
        }
        model.put("movies", movies);
        return "index";
    }

    @RequestMapping(value = "/by-date")
    public String byDate(@RequestParam(value = "date") String dat, Map<String, Object> model) throws ParseException {
        System.out.println("dat");
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dd = format.parse(dat);
        System.out.println(dd);
        Date date = new Date(dd.getTime());
        movies = movieService.getAllMoviesByDay(date);
        model.put("movies", movies);
        return "index";
    }


}