package com.techelevator.routeModels;

import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Root {

    public ArrayList<RouteAPI> routes;
    public ArrayList<Double> bbox;
    public Metadata metadata;

    public ArrayList<RouteAPI> getRoutes() {
        return routes;
    }

    public void setRoutes(ArrayList<RouteAPI> routes) {
        this.routes = routes;
    }

    public ArrayList<Double> getBbox() {
        return bbox;
    }

    public void setBbox(ArrayList<Double> bbox) {
        this.bbox = bbox;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
