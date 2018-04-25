package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutMovieController {

    @RequestMapping(value = "/about-movie")
    public String about()
    {
        return "about-movie";
    }
}
