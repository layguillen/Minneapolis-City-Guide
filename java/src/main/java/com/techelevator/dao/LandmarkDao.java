package com.techelevator.dao;

import com.techelevator.model.Landmark;

import java.util.List;

public interface LandmarkDao {

    List<Landmark> listLandmarks();

    Landmark getLandmark();

    boolean createLandmark(Landmark landmark);

    Landmark updateLandmark(Landmark landmark);
}
