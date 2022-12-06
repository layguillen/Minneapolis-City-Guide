package com.techelevator.dao;

import com.techelevator.model.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcAddressDao implements AddressDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAddressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Address> listOfAddresses(){
        return null;
    }

    @Override
    public Address getAddress(){

        return null;
    }

    @Override
    public boolean createAddress(Address address){
        String sql = "";
        return false;
    }

    private Address mapRowToAddress(SqlRowSet results){
        Address address = new Address();

        return address;
    }


}
