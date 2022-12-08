package com.techelevator.dao;

import com.techelevator.model.Review;

import java.util.List;

public interface ReviewDao {

    List<Review> listReviews(int landmarkId);

//    Review getReview(int id);

    boolean createReview(Review review);
}
