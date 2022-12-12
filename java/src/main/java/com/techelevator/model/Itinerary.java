package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.routeModels.RouteAPI;

import java.util.ArrayList;

public class Itinerary {

    @JsonProperty("id")
    private int itineraryId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("start_id")
    private int startId;

    public Itinerary(){

    };

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
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



}
