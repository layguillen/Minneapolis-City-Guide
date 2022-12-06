package com.techelevator.dao;

import com.techelevator.model.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcHotelDao implements HotelDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcHotelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hotel> listHotels(){
        List<Hotel> list = new ArrayList<>();

        String sql = " SELECT id, address_id, star_rating, name " +
                    " FROM hotels ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            list.add(mapRowToHotel(result));
        }

        return list;
    }

    @Override
    public Hotel getHotel(int hotelId){
        if(hotelId == 0) throw new IllegalArgumentException("Hotel Id cannot be null");

        Hotel hotel = new Hotel();

        String sql = " SELECT id, address_id, star_rating, name " +
                    " FROM hotels " +
                    " WHERE id = ? ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, hotelId);
        if(result.next()){
            return mapRowToHotel(result);
        }

        return hotel;
    }

    private Hotel mapRowToHotel(SqlRowSet results){
        Hotel hotel = new Hotel();

        hotel.setHotelId(results.getInt("id"));
        hotel.setAddressId(results.getInt("address_id"));
        hotel.setStarRating(results.getInt("star_rating"));
        hotel.setName(results.getString("name"));


        return hotel;
    }

}
