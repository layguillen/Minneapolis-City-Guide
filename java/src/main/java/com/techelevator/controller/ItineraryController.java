package com.techelevator.controller;

import com.techelevator.dao.ItineraryDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import com.techelevator.routeModels.RouteAPI;
import com.techelevator.services.iRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ItineraryController {

    private ItineraryDao itineraryDao;

    public ItineraryController(ItineraryDao itineraryDao) {
        this.itineraryDao = itineraryDao;
    }

    @RequestMapping(path="/itinerary/list", method = RequestMethod.GET)
    public List<Itinerary> getAllItineraries(){
        return itineraryDao.listItinerary();
    }

    @RequestMapping(path="/itinerary/{id}", method= RequestMethod.GET)
    public Itinerary getItinerary(@Valid @PathVariable("id") int itineraryId){
        Itinerary result = itineraryDao.getItinerary(itineraryId);
        if(result == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Itinerary not found.", null);
        }
        return result;
    }


    @RequestMapping(path= "/itinerary/new", method= RequestMethod.POST)
    public Itinerary createItinerary(@Valid @RequestBody Itinerary itinerary){
        boolean success = itineraryDao.createItinerary(itinerary);
        if(!success){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Itinerary to be added was not found", null);
        }
        return itinerary;
    }

    @RequestMapping(path= "/itinerary/{id}", method= RequestMethod.DELETE)
    public boolean deleteItinerary(@Valid @PathVariable("id")int itineraryId){
        boolean success = itineraryDao.deleteItinerary(itineraryId);
        if(!success){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Itinerary to be added was not found", null);
        }else{
            return success;
        }
    }


}
