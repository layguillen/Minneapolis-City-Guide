package com.techelevator.dao;

import com.techelevator.model.Address;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class JdbcAddressDaoTest extends BaseDaoTests{
    protected static final Address ADDRESS_1 = new Address(1, "2400 3rd Ave", "Minneapolis", "MN", 55404, "-93.274040,44.958500");
    protected static final Address ADDRESS_2 = new Address(2,"60 E Broadway", "Bloomington", "MN", 55425, "-93.239449,44.856529");

    private JdbcAddressDao sut;

    @BeforeEach
    void setUp() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAddressDao(jdbcTemplate);
    }

    //doesnt work
    @Test
    void listOfAddresses() {
        List<Address> addresses = sut.listOfAddresses();
        Assert.assertNull(addresses);
        Assert.assertEquals(2, addresses.size());
        Assert.assertEquals(ADDRESS_1, addresses.get(0));
        Assert.assertEquals(ADDRESS_2, addresses.get(1));

    }

    @Test
    void getAddress() {
    }

    @Test
    void createAddress() {
    }
}