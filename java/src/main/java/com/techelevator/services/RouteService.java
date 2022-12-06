package com.techelevator.services;

import com.techelevator.model.Route;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RouteService implements iRouteService{

    private static final String API_URL = "";
    private static final String API_KEY = "5b3ce3597851110001cf624825acbbd93a1c4750ac7148d566eec1ad";

    private RestTemplate restTemplate = new RestTemplate();

    public Route getRoute(){
        Route route = restTemplate.getForObject(API_URL, Route.class);

        return route;
    }



}