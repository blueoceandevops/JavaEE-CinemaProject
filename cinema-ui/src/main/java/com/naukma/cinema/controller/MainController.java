package com.naukma.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @RequestMapping(value = "/")
    public String main(/*HttpServletRequest request, HttpServletResponse response,
                       ServletContext servletContext, TemplateEngine templateEngine*/) {
        //MovieServise servise = new MovieServise();
        //List<Movie> movies = servise.getAll();
        //ctx = new WebContext(request, servletContext, request.getLocale());
        //ctx.setVariable("movies", movies);
        //templateEngine.process("index", ctx, response.getWriter());
        return "index";
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