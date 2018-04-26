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

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/")
    public void main(HttpServletRequest request, HttpServletResponse response,
                       ServletContext servletContext, TemplateEngine templateEngine) throws IOException {

        List<Movie> movies = movieService.getAllRunningMovies();

        WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
        ctx.setVariable("movies", movies);

        templateEngine.process("index", ctx, response.getWriter());
    }

    @RequestMapping(value = "/soon")
    public String soon()
    {
        return "soon";
    }

    @RequestMapping(value = "/about-us")
    public String aboutUs()
    {
        return "about-us";
    }

}