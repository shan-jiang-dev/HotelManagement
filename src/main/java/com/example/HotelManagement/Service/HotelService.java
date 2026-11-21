package com.example.HotelManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	public Hotel saveHotel(HotelDTO hotelDTO) {
		
		Hotel hotel = new Hotel();
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(hotelDTO.getCity());
		hotel.setPostalCode(hotelDTO.getPostalCode());
		hotel.setRating(hotelDTO.getRating());
		hotel.setAvailabile(hotelDTO.isAvailabile());
		hotelRepository.save(hotel);  
		return hotel;
	}
}
