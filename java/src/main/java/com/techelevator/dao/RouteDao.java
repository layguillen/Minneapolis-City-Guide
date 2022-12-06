package com.techelevator.dao;

import com.techelevator.model.Route;

import java.util.List;

public interface RouteDao {

    List<Route> listRoutes();

    Route getRoute();

    boolean createRoute(Route route);

    Route addLandmarkToRoute(Route route, int landmarkId);

    Route removeLandmarkToRoute(Route route, int landmarkId);

    Route updateStartingLocation(Route route, int startId);

}
