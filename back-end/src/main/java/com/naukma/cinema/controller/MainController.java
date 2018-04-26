package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.service.MovieService;
import com.naukma.cinema.service.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.Date;
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
    public @ResponseBody List<Movie> byFilm(){
        System.out.println(movies.toString());
        movies = movieService.getAllRunningMovies();
        for(Movie movie : movies){
            System.out.println(movie.getTitle() + movie.getReleaseDate());
        }
        return movies;
    }

    @RequestMapping(value = "/")
    public String main(Map<String, Object> model){
        if(movies == null) {
            movies = movieService.getAllRunningMovies();
        }
        System.out.println("Movies");
        for(Movie movie : movies){
            System.out.println(movie.getTitle() + movie.getReleaseDate());
        }
        model.put("movies", movies);
        return "index";
    }

    @RequestMapping(value = "/by-date")
    public @ResponseBody List<Movie>  byDate(@RequestParam(value = "date") Date date)
    {
        movies = movieService.getAllRunningMovies();
        for(Movie movie : movies){
            System.out.println(movie.getTitle() + movie.getReleaseDate());
        }
        return movies;
    }


}