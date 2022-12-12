package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Itinerary {

    @JsonProperty("id")
    private int itineraryId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("hotel_id")
    private int hotelId;

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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

}
