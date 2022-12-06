package com.techelevator.controller;

import com.techelevator.dao.HotelDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HotelController {

    private HotelDao hotelDao;

    public HotelController(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }
}
