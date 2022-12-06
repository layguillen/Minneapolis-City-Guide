package com.techelevator.controller;

import com.techelevator.services.iRouteService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RouteController {

    private iRouteService routeService;

    public RouteController(iRouteService routeService) {
        this.routeService = routeService;
    }
}
