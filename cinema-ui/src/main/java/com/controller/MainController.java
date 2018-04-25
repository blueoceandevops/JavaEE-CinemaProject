package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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