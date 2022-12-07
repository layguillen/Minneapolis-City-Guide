package com.techelevator.dao;

import com.techelevator.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAddressDao implements AddressDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAddressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Address> listOfAddresses(){
        List<Address> list = new ArrayList<>();

        String sql = " SELECT id, long_lat, street, city, state, zip" +
                " FROM addresses ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
        while(result.next()){
            list.add(mapRowToAddress(result));
        }

        return list;
    }

    @Override
    public Address getAddress(int id){
        if(id == 0) throw new IllegalArgumentException("Address ID cannot be null.");

        String sql = " SELECT id, long_lat, street, city, state, zip " +
                     " FROM addresses " +
                     " WHERE id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if (result.next()){
            return mapRowToAddress(result);
        }
        return null;
    }

    @Override
    public boolean createAddress(Address address){
        String sql = "INSERT INTO landmarks (id, long_lat, street, city, state, zip) " +
                " VALUES(?, ?, ?, ?, ?, ?); ";

        return jdbcTemplate.update(sql,
                address.getAddressId(),
                address.getLongLat(),
                address.getStreet(),
                address.getCity(),
                address.getStateAbbrev(),
                address.getZipCode()) == 1;
    }

    private Address mapRowToAddress(SqlRowSet results){
        Address address = new Address();
        address.setAddressId(results.getInt("id"));
        address.setLongLat(results.getString("long_lat"));
        address.setStreet(results.getString("street"));
        address.setCity(results.getString("city"));
        address.setStreet(results.getString("street"));
        address.setStateAbbrev(results.getString("state"));
        address.setZipCode(results.getInt("zip"));
        return address;
    }


}
