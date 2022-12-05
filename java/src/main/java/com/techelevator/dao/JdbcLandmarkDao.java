package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Landmark> listLandmarks(){
        return null;
    }

    @Override
    public Landmark getLandmark(){
        return null;
    }

    @Override
    public boolean createLandmark(Landmark landmark){
        return false;
    }

    @Override
    public Landmark updateLandmark(Landmark landmark){
        return null;
    }

    private Landmark mapRowToLandmark(SqlRowSet results){
        Landmark landmark = new Landmark();

        return landmark;
    }

}
