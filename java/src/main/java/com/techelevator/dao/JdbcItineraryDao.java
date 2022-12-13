package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;
    private JdbcUserDao jdbcUserDao;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate, JdbcUserDao jdbcUserDao) {

        this.jdbcTemplate = jdbcTemplate;
        this.jdbcUserDao = jdbcUserDao;
    }

    //TODO fix join in sql to the associative table to retrieve the landmarks
    //gets itinerary from database
    @Override
    public List<Itinerary> listItinerary(Principal principal){
        int userId = jdbcUserDao.findIdByUsername(principal.getName());

        List<Itinerary> list = new ArrayList<>();
        String sql = "SELECT itinerary.id, user_id, hotel_id, landmarks_itinerary.landmark_id " +
                " FROM itinerary " +
                " JOIN landmarks_itinerary ON landmarks_itinerary.itinerary_id = itinerary.id " +
                " WHERE user_id = ?; ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        while(result.next()){
            list.add(mapRowToIntinerary(result));
        }
        return list;
    }

    //gets specific itinerary from database
    @Override
    public Itinerary getItinerary(int itineraryId, Principal principal){
        return listItinerary(principal).get(itineraryId-1);

    }

    //insert new itinerary into database
    @Override
    public int createItinerary(Itinerary itinerary, Principal principal){

        int userId = jdbcUserDao.findIdByUsername(principal.getName());

        String sql = " INSERT INTO itinerary(user_id, hotel_id) " +
                " VALUES(?, ?) RETURNING id ";

        int itineraryId = jdbcTemplate.queryForObject(sql, int.class, userId, itinerary.getHotelId());

        return itineraryId;
    }

    //inserts itinerary id and landmark ids into associative table
    @Override
    public void insertItineraryIntoAssociative(int itineraryId, Landmark[] landmarks){
        for(Landmark landmark: landmarks){
            String sql = " INSERT INTO landmarks_itinerary (itinerary_id, landmark_id) " +
                    " VALUES(?, ?) ";
            jdbcTemplate.update(sql, itineraryId, landmark.getLandmarkId());
        }
    }

    //deletes the itinerary from landmarks_itinerary table
    @Override
    public void deleteItineraryFromAssociative(int itineraryId){

        String sql = " DELETE FROM landmarks_itinerary " +
                " WHERE id = ? ";

        jdbcTemplate.update(sql, itineraryId);

    }

    //deletes the itinerary from itinerary table
    @Override
    public void deleteItinerary(int itineraryId){

        String sql = " DELETE FROM itinerary " +
                " WHERE id = ? ";

        jdbcTemplate.update(sql, itineraryId);

    }


    //adds landmark to itinerary
    @Override
    public void addLandmarkToItinerary(Itinerary itinerary, int landmarkId){
        if(itinerary == null) throw new IllegalArgumentException("Itinerary cannot be null");

        String sql = " INSERT INTO landmarks_itinerary (itinerary_id, landmark_id) " +
                    " VALUES(?, ?) ";

        jdbcTemplate.update(sql, itinerary.getItineraryId(), landmarkId);

    }

    //removes landmark from itinerary
    @Override
    public void removeLandmarkToItinerary(Landmark landmark, int itineraryId){
        if(landmark == null) throw new IllegalArgumentException("Landmark cannot be null");

        String sql = " DELETE FROM landmarks_itinerary " +
                " WHERE landmark_id = ? AND itinerary_id = ?  ";

        jdbcTemplate.update(sql, landmark.getLandmarkId(), itineraryId);

    }

    private Itinerary mapRowToIntinerary(SqlRowSet results){
        Itinerary itinerary = new Itinerary();

        itinerary.setItineraryId(results.getInt("id"));
        itinerary.setUserId(results.getInt("user_id"));
        itinerary.setHotelId(results.getInt("hotel_id"));

        return itinerary;
    }

//    private Landmark mapRowToLandmark(SqlRowSet results){
//
//    }

}
