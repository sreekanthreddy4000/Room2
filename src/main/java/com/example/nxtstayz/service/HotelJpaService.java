package com.example.nxtstayz.service;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.repository.HotelRepository;
import com.example.nxtstayz.repository.HotelJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class HotelJpaService implements HotelRepository {

    @Autowired
    private HotelJpaRepository hotelJpaRepository;

    @Override
    public ArrayList<Hotel> getHotels() {
        List<Hotel> hotelList = hotelJpaRepository.findAll();
        ArrayList<Hotel> hotels = new ArrayList<>(hotelList);
        return hotels;
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        try {
            Hotel hotel = hotelJpaRepository.findById(hotelId).get();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        try {
            hotelJpaRepository.save(hotel);
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel updateHotel(int hotelId, Hotel hotel) {
        try {
            Hotel newHotel = hotelJpaRepository.findById(hotelId).get();

            if (newHotel == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

            if (hotel.getHotelName() != null) {
                newHotel.setHotelName(hotel.getHotelName());
            }

            if (hotel.getLocation() != null) {
                newHotel.setLocation(hotel.getLocation());
            }

            if (hotel.getRating() != 0) {
                newHotel.setRating(hotel.getRating());
            }
            hotelJpaRepository.save(newHotel);
            return newHotel;

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        try {
            hotelJpaRepository.deleteById(hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }


    @Override
    public Hotel getRoomHotel(int hotelId) {
        try {
            Hotel room = roomJpaRepository.findById(roomId).get();
            Hotel hotel = room.getHotel();
            return hotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

}
