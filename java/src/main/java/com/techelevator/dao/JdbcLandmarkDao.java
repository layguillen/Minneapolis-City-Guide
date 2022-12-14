package com.techelevator.dao;

import com.techelevator.model.Address;
import com.techelevator.model.Landmark;
import com.techelevator.model.Review;
import com.techelevator.model.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao{

    private JdbcTemplate jdbcTemplate;
    private JdbcAddressDao jdbcAddressDao;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate, JdbcAddressDao jdbcAddressDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.jdbcAddressDao = jdbcAddressDao;
    }

    @Override
    public List<Landmark> listLandmarks(){
        List<Landmark> list = new ArrayList<>();
        String sql = "SELECT landmarks.id, address_id, landmarks.name, landmarks.type, types.name AS type_name, description, likes, img_URL, is_pending" +
                " FROM landmarks " +
                " JOIN types ON landmarks.type = types.id " +
                " ORDER BY landmarks.name ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            Landmark landmark = mapRowToLandmark(result);

            //add appropriate address to each landmark
            String addressSql = " SELECT id, street, city, state, zip " +
                " FROM addresses " +
                " WHERE id = ?";
            SqlRowSet addressResult = jdbcTemplate.queryForRowSet(addressSql, landmark.getAddressId());
            if (addressResult.next()){
                landmark.setAddress(mapRowToAddress(addressResult));
            }

            //add appropriate reviews to each landmark
            String reviewSql = " SELECT id, title, description, landmark_id, is_liked, user_id, username " +
                    " FROM reviews " +
                    " WHERE landmark_id = ?";
            SqlRowSet reviewResult = jdbcTemplate.queryForRowSet(reviewSql, landmark.getLandmarkId());
            while (reviewResult.next()){
                landmark.addReview(mapRowToReview(reviewResult));
            }

            list.add(landmark);
        }
        return list;
    }

    @Override
    public Landmark getLandmark(int landmarkId){
        List<Landmark> landmarks = listLandmarks();
        for(Landmark landmark: landmarks){
            if(landmark.getLandmarkId() == landmarkId){
                return landmark;
            }
        }
        return new Landmark();
    }


    //TODO: check sql
    @Override
    public boolean createLandmark(Landmark landmark, int addressId){

        String imgUrl = "data:image/jpeg;base64,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";

        String sql = "INSERT INTO landmarks (address_id, name, type, description, likes, img_URL, is_pending) " +
                    " VALUES(?, ?, ?, ?, ?, ?, ?); ";

         return jdbcTemplate.update(sql, addressId, landmark.getName(),
                                    landmark.getType().getTypeId(),
                                    landmark.getDescription(),
                                    landmark.getLikes(),
                                    imgUrl,
                                    landmark.isPending()) == 1;
    }

    @Override
    public Landmark updateLandmarkLikes(Landmark landmark, int landmarkId){
        Landmark result = landmark;
        int likeCount = landmark.getLikes() + 1;

        String sql = " UPDATE landmarks " +
                    " SET likes = ? " +
                    " WHERE id = ? ";
        int num = jdbcTemplate.update(sql, likeCount, landmarkId);

        if(num != 1){
            return null;
        }
        return result;
    }

    @Override
    public Landmark updatePendingStatus(Landmark landmark){
        Landmark result = landmark;

        String sql = " UPDATE landmarks " +
                " SET is_pending = ? " +
                " WHERE id = ? ";

        int num = jdbcTemplate.update(sql, false, landmark.getLandmarkId());

        if(num != 1){
            return null;
        }

        return result;
    }


    @Override
    public boolean deleteLandmark(int landmarkId){

        int lengthBefore = listLandmarks().size();

        String sql = " DELETE FROM landmarks " +
                " WHERE id = ? ";

        jdbcTemplate.update(sql, landmarkId);

        int lengthAfter = listLandmarks().size();

        if(lengthBefore == lengthAfter){
            return false;
        }
        return true;

    }




    private Landmark mapRowToLandmark(SqlRowSet results){
        Landmark landmark = new Landmark();

        landmark.setLandmarkId(results.getInt("id"));
        landmark.setAddressId(results.getInt("address_id"));
        landmark.setName(results.getString("name"));
        landmark.setType(mapRowToType(results));
        landmark.setDescription(results.getString("description"));
        landmark.setLikes(results.getInt("likes"));
        landmark.setImgUrl(results.getString("img_url"));
        landmark.setPending(results.getBoolean("is_pending"));
        return landmark;
    }
    private Address mapRowToAddress(SqlRowSet results){
        Address address = new Address();
        address.setAddressId(results.getInt("id"));
        address.setStreet(results.getString("street"));
        address.setCity(results.getString("city"));
        address.setStreet(results.getString("street"));
        address.setStateAbbrev(results.getString("state"));
        address.setZipCode(results.getInt("zip"));
        return address;
    }

    private Type mapRowToType(SqlRowSet results){
        Type type = new Type();
        type.setName(results.getString("type_name"));
        type.setTypeId(results.getInt("type"));
        return type;
    }

    private Review mapRowToReview(SqlRowSet results){
        Review review = new Review();
        review.setReviewId(results.getInt("id"));
        review.setTitle(results.getString("title"));
        review.setDescription(results.getString("description"));
        review.setLandmarkId(results.getInt("landmark_id"));
        review.setLiked(results.getBoolean("is_liked"));
        review.setUserId(results.getInt("user_id"));
        review.setUsername(results.getString("username"));

        return review;
    }
}
