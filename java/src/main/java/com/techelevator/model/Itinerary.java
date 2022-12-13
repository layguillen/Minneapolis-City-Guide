package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Itinerary {

    //TODO: add list of landmarks to itinerary properties, then fix mapper in Jdbc class

    @JsonProperty("id")
    private int itineraryId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("hotel_id")
    private int hotelId;

    private List<Landmark> landmarks;

    public Itinerary(){
    };

    public List<Landmark> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<Landmark> landmarks) {
        this.landmarks = landmarks;
    }

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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

}
