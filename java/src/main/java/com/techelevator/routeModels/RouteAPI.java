package com.techelevator.routeModels;

import java.util.ArrayList;

public class RouteAPI {

    public Summary summary;
    public ArrayList<Segment> segments;
    public ArrayList<Double> bbox;
    public String geometry;
    public ArrayList<Integer> way_points;

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> segments) {
        this.segments = segments;
    }

    public ArrayList<Double> getBbox() {
        return bbox;
    }

    public void setBbox(ArrayList<Double> bbox) {
        this.bbox = bbox;
    }

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public ArrayList<Integer> getWay_points() {
        return way_points;
    }

    public void setWay_points(ArrayList<Integer> way_points) {
        this.way_points = way_points;
    }
}
