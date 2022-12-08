package com.techelevator.services;

import com.techelevator.model.Landmark;
import com.techelevator.model.Route;
import com.techelevator.routeModels.Root;
import com.techelevator.routeModels.RouteAPI;

import java.util.ArrayList;
import java.util.List;

public interface iRouteService {

    //Route createRoute(String token, Route route);

    ArrayList<RouteAPI> createRoute(Landmark[] landmarks);
}
