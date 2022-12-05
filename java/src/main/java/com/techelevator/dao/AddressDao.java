package com.techelevator.dao;

import com.techelevator.model.Address;

import java.util.List;

public interface AddressDao {

    List<Address> listOfAddresses();

    Address getAddress();

    boolean createAddress(Address address);
}
