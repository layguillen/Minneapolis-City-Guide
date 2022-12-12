package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> listItinerary();

    Itinerary getItinerary(int itineraryId);

    boolean createItinerary(Itinerary itinerary, List<Landmark> landmarks);

    boolean deleteItinerary(int itineraryId);

    void addLandmarkToItinerary(Itinerary itinerary, int landmarkId);

    void removeLandmarkToItinerary(Landmark landmark, int itineraryId);

}
