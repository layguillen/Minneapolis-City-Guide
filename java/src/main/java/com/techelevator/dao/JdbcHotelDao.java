package com.techelevator.dao;

import com.techelevator.model.Hotel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcHotelDao implements HotelDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcHotelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hotel> listHotels(){
        return null;
    }

    @Override
    public Hotel getHotel(){
        return null;
    }

    private Hotel mapRowToHotel(SqlRowSet results){
        Hotel hotel = new Hotel();

        return hotel;
    }

}
