package com.techelevator.controller;

import com.techelevator.dao.RouteDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landmark;
import com.techelevator.model.Route;
import com.techelevator.routeModels.RouteAPI;
import com.techelevator.services.iRouteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class RouteController {

    private iRouteService routeService;
    private RouteDao routeDao;
    private UserDao userDao;

    public RouteController(iRouteService routeService, UserDao userDao, RouteDao routeDao) {
        this.routeService = routeService;
        this.routeDao = routeDao;
        this.userDao = userDao;
    }

    //calls API to get a new route
    @RequestMapping(path= "/route", method= RequestMethod.POST)
    public ArrayList<RouteAPI> getNewRoute(String token, List<Landmark> landmarks){

        ArrayList<RouteAPI> routes = new ArrayList<>();
        routes = routeService.createRoute(token, landmarks);

        return routes;
    }

}
