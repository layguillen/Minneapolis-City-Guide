package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //gets itinerary from database
    @Override
    public List<Itinerary> listItinerary(){
        List<Itinerary> list = new ArrayList<>();
        String sql = "SELECT * " +
                " FROM itinerary ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        while(result.next()){
            list.add(mapRowToIntinerary(result));
        }
        return list;
    }

    //gets specific itinerary from database
    @Override
    public Itinerary getItinerary(int itineraryId){
        return listItinerary().get(itineraryId-1);

    }

    //insert new itinerary into database
    @Override
    public boolean createItinerary(Itinerary itinerary){


        int lengthBefore = listItinerary().size();

        String sql = " INSERT INTO itinerary(user_id, hotel_id) " +
                " VALUES(?, ?) RETURNING id ";

        jdbcTemplate.update(sql, itinerary.getUserId(), itinerary.getHotelId());

        int lengthAfter = listItinerary().size();

        if(lengthBefore == lengthAfter){
            return false;
        }
        return true;
    }

    //deletes the itinerary
    @Override
    public boolean deleteItinerary(int itineraryId){

        int lengthBefore = listItinerary().size();

        String sql = " DELETE FROM itinerary " +
                " WHERE id = ? ";

        jdbcTemplate.update(sql, itineraryId);

        int lengthAfter = listItinerary().size();

        if(lengthBefore == lengthAfter){
            return false;
        }
        return true;

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

}
