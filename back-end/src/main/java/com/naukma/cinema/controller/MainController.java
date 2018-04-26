package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;


    @RequestMapping(value = "/soon")
    public void soon(HttpServletRequest request, HttpServletResponse response,
                       ServletContext servletContext, TemplateEngine templateEngine) throws IOException {
        List<Movie> moviesSoon = movieService.getAllRunningMovies();
        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("moviesSoon", moviesSoon);

        templateEngine.process("soon", ctx, response.getWriter());
    }

    @RequestMapping(value = "/about-us")
    public String aboutUs()
    {
        return "about-us";
    }

    @RequestMapping(value = "/")
    public String main(Map<String, Object> model){
        List<Movie> movies = movieService.getAllRunningMovies();
        model.put("movies", movies);
        return "index";
    }
}