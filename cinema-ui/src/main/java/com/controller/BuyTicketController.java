package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuyTicketController {
    @RequestMapping(value = "/buy-ticket")
    public String about()
    {
        return "buy-ticket";
    }
}
