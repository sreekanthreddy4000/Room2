package com.example.nxtstayz.repository;

import java.util.*;

import com.example.nxtstayz.model.Hotel;

public interface HotelRepository {

    ArrayList<Hotel> getHotels();

    Hotel getHotelById(int hotelId);

    Hotel addHotel(Hotel hotel);

    Hotel updateHotel(int hotelId, Hotel hotel);

    void deleteHotel(int hotelId);
}