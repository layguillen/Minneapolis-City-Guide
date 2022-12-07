package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> listReviews(){
        List<Review> reviews = new ArrayList<>();
        String sql = " SELECT id, landmark_id, user_id, title, isliked, description " +
                " FROM reviews ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Review review = mapRowToReview(result);
            reviews.add(review);
        }
        return reviews;
    }


    @Override
    public boolean createReview(Review review){
        String sql = " INSERT INTO reviews(id, landmark_id, user_id, title, isliked, description) " +
                " VALUES (?, ?, ?, ?, ?, ?) ";


        return jdbcTemplate.update(sql, review.getReviewId(), review.getLandmarkId(), review.getUserId(), review.getTitle(), review.getIsLiked(), review.getDescription())==1;
    }


    private Review mapRowToReview(SqlRowSet results){
        Review review = new Review();

        return review;
    }
}
