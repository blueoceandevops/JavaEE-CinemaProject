package com.naukma.cinema.controller;

import com.naukma.cinema.domain.Movie;
import com.naukma.cinema.domain.MovieSession;
import com.naukma.cinema.domain.OccupiedSeat;
import com.naukma.cinema.service.MovieSessionService;
import com.naukma.cinema.service.OccupiedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BuyTicketController {

    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private OccupiedSeatService occupiedSeatService;

    @RequestMapping(value = "/buy-ticket")
    public String about(@RequestParam(value = "id") Integer id, Map<String, Object> model)
    {
        MovieSession currentMovieSession = movieSessionService.getById(id);
        String title = currentMovieSession.getMovie().getTitle();
        Map<Integer, Map<Integer, Boolean>> places = new HashMap();
        List<OccupiedSeat> occupiedSeats = occupiedSeatService.findOccupiedSeatBySessionId(currentMovieSession.getId());
        for (OccupiedSeat seat: occupiedSeats){
            if (places.containsKey(seat.getRow())){
                places.get(seat.getRow()).put(seat.getSeat(), false);
            } else {
                Map<Integer, Boolean> inPlaces = new HashMap<>();
                inPlaces.put(seat.getSeat(), false);
                places.put(seat.getRow(), inPlaces);
            }
        }
        for (int i=1; i<=currentMovieSession.getHall().getRows(); i++)
        {
            Map<Integer, Boolean> inPlaces;
            if(places.containsKey(i))
            {
                inPlaces = places.get(i);
            } else {
                inPlaces = new HashMap<>();
                places.put(i, inPlaces);
            }

            for (int j = 1; j<=currentMovieSession.getHall().getPlacesInRow(); j++)
            {
                if(inPlaces.containsKey(j)) continue;
                else{
                    inPlaces.put(j, true);
                }
            }
        }
        model.put("currentMovieSession", currentMovieSession);
        model.put("title", title);
        model.put("places", places);
        return "buy-ticket";
    }
}
