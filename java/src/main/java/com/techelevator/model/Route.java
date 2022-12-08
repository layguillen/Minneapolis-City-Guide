package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.routeModels.RouteAPI;

import java.util.ArrayList;

public class Route {

    @JsonProperty("id")
    private int routeId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("start_id")
    private int startId;
    @JsonProperty("created_date")
    private String date;
    @JsonProperty("name")
    private String name;



    private ArrayList<RouteAPI> routes;



    public Route(){};

    public ArrayList<RouteAPI> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<RouteAPI> routes) {
        this.routes = routes;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
