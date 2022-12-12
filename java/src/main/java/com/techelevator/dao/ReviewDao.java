package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> listReviews(int landmarkId);
    List<Review> listReviews();

//    Review getReview(int id);

    Review createReview(Review review, int landmarkId);
}
