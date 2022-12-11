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
        String sql = " SELECT reviews.id, landmark_id, reviews.user_id, title, is_liked, description, users.username " +
                " FROM reviews " +
                " JOIN users ON users.user_id = reviews.user_id ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while (result.next()){
            Review review = mapRowToReview(result);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Review> listReviews(int landmarkId){
        List<Review> reviews = new ArrayList<>();
        String sql = " SELECT reviews.id, landmark_id, reviews.user_id, title, is_liked, description, users.username " +
                " FROM reviews " +
                " JOIN users ON users.user_id = reviews.user_id " +
                " WHERE landmark_id = ? ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId);
        while (result.next()){
            Review review = mapRowToReview(result);
            reviews.add(review);
        }
        return reviews;
    }

//    @Override
//    public Review getReview(int id) {
//
//        return listReviews().get(id-1);
//    }


    @Override
    public Review createReview(Review review){

        String sql = " INSERT INTO reviews(landmark_id, user_id, title, is_liked, description) " +
                " VALUES (?, ?, ?, ?, ?) RETURNING id; ";

        int newId = jdbcTemplate.queryForObject(sql, int.class, review.getLandmarkId(),
                review.getUserId(), review.getTitle(), review.getIsLiked(),
                review.getDescription());

        review.setReviewId(newId);

        return review;
    }


    private Review mapRowToReview(SqlRowSet results){
        Review review = new Review();
        review.setReviewId(results.getInt("id"));
        review.setLandmarkId(results.getInt("landmark_id"));
        review.setUserId(results.getInt("user_id"));
        review.setTitle(results.getString("title"));
        review.setLiked(results.getBoolean("is_liked"));
        review.setDescription(results.getString("description"));
        review.setUsername(results.getString("username"));
        return review;
    }
}
