package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: fix sql
    @Override
    public List<Landmark> listLandmarks(){
        List<Landmark> list = new ArrayList<>();
        String sql = "SELECT id, address_id, name, type, description, average_rating, img_URL " +
                    " FROM landmarks ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            list.add(mapRowToLandmark(result));
        }
        return list;
    }

    //TODO: fix sql
    @Override
    public Landmark getLandmark(int landmarkId){
        if(landmarkId == 0) throw new IllegalArgumentException("Landmark ID cannot be null.");

        Landmark landmark = new Landmark();

        String sql = "SELECT id, address_id, name, type, description, average_rating, img_URL " +
                    " FROM landmarks " +
                    " WHERE id = ?; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId);
        if (result.next()){
            return mapRowToLandmark(result);
        }
        return landmark;
    }

    //TODO: check sql
    @Override
    public boolean createLandmark(Landmark landmark){
        String sql = "INSERT INTO landmarks (id, address_id, name, type, description, average_rating, img_URL) " +
                    " VALUES(?, ?, ?, ?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                                    landmark.getLandmarkId(),
                                    landmark.getAddressId(),
                                    landmark.getName(),
                                    landmark.getType(),
                                    landmark.getDescription(),
                                    landmark.getAverageRating(),
                                    landmark.getImgUrl()) == 1;
    }

    //TODO: fix sql
    @Override
    public Landmark updateLandmark(Landmark landmark){
        Landmark result = landmark;
        String sql = " UPDATE landmarks " +
                    " SET " +
                    " WHERE id = ? ";
        int num = jdbcTemplate.update(sql, landmark.getLandmarkId());

        if(num != 1){
            return null;
        }
        return result;
    }

    private Landmark mapRowToLandmark(SqlRowSet results){
        Landmark landmark = new Landmark();

        landmark.setLandmarkId(results.getInt("landmark_id"));
        landmark.setAddressId(results.getInt("address_id"));
        landmark.setName(results.getString("name"));
        landmark.setType(results.getString("type"));
        landmark.setDescription(results.getString("description"));
        landmark.setAverageRating(results.getInt("average_rating"));
        landmark.setImgUrl(results.getString("img_URL"));

        return landmark;
    }

}
