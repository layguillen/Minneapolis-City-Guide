package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty ("id")
    private int addressId;
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("state")
    private String stateAbbrev;
    @JsonProperty("zip")
    private int zipCode;
    @JsonProperty("long_lat")
    private String longLat;
    @JsonProperty("longitude")
    private double longitude;
    @JsonProperty("latitude")
    private double latitude;

    public Address(){};

    public Address(int addressId, String street, String city, String stateAbbrev, int zipCode) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.stateAbbrev = stateAbbrev;
        this.zipCode = zipCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getLongLat() {
        return longLat;
    }

    public void setLongLat(String longLat) {
        this.longLat = longLat;
        this.latitude = Double.parseDouble(longLat.split(",")[1]);
        this.longitude = Double.parseDouble(longLat.split(",")[0]);
    }

    public double getLatitude(){
        return this.latitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
}
