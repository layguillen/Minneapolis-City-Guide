package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {

    @JsonProperty("id")
    private int reviewId;
    @JsonProperty("landmark_id")
    private int landmarkId;
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("description")
    private String description;

    public Review(){};


    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
