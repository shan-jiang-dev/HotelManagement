package com.example.HotelManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
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
		hotel.setAvailable(hotelDTO.isAvailable());
		hotelRepository.save(hotel);  
		return hotel;
	}
	
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
	
	public Hotel getHotelById(Long id) {
		Optional<Hotel> hotelBox = hotelRepository.findById(id);
		if (hotelBox.isPresent()) {
			return hotelBox.get();
		}
		return null;
	}
	
	public Hotel updateHotel(HotelDTO hotelDTO, Long id) {
		Hotel hotel = getHotelById(id);
		
		if (hotel != null) {
			hotel.setName(hotelDTO.getName());
			hotel.setAddress(hotelDTO.getAddress());
			hotel.setCity(hotelDTO.getCity());
			hotel.setPostalCode(hotelDTO.getPostalCode());
			hotel.setRating(hotelDTO.getRating());
			hotel.setAvailable(hotelDTO.isAvailable());
			return hotelRepository.save(hotel);
			
		}
		return hotel;
		
		
	}
	
	public void deleteHotel(Long id) {
		Hotel hotel = getHotelById(id);
		if (hotel != null) {
			hotelRepository.deleteById(id);
		}
	}
	
	public Hotel updateHotelAddress(UpdateHotelAddressDTO updateHotelAddressDTO, Long id) {
		
		Hotel hotel = getHotelById(id);
		
		if (hotel != null) {
			hotel.setAddress(updateHotelAddressDTO.getAddress());
			hotel.setCity(updateHotelAddressDTO.getCity());
			hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());
			return hotelRepository.save(hotel);		
		}
		return hotel;
	}
	

}
