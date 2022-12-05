package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {

    @JsonProperty("id")
    private int routeId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("hotel_id")
    private int hotelId;
    @JsonProperty("created_date")
    private String date;
    @JsonProperty("name")
    private String name;

    public Route(){};

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

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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
