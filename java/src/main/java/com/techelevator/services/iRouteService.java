package com.techelevator.services;

import com.techelevator.model.Landmark;
import com.techelevator.routeModels.RouteAPI;

import java.util.ArrayList;

public interface iRouteService {

    //Itinerary createRoute(String token, Itinerary route);

    ArrayList<RouteAPI> createRoute(Landmark[] landmarks);
}
