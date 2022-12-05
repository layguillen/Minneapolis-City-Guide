package com.techelevator.dao;

import com.techelevator.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcReviewDao implements ReviewDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Review> listReviews(){
        return null;
    }

    @Override
    public boolean createReview(Review review){
        String sql = "";

        return false;
    }

    private Review mapRowToReview(SqlRowSet results){
        Review review = new Review();

        return review;
    }
}
