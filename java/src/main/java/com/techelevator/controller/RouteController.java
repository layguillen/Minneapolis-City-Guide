package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.model.Route;
import com.techelevator.services.iRouteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class RouteController {

    private iRouteService routeService;
    private UserDao userDao;

    public RouteController(iRouteService routeService, UserDao userDao) {

        this.routeService = routeService;
        this.userDao = userDao;
    }

    @RequestMapping(path= "", method= RequestMethod.POST)
    public Route getRoute(Principal principal){
        Route route = new Route();
        route.setUserId(userDao.findIdByUsername(principal.getName()));

        return route;
    }

}
