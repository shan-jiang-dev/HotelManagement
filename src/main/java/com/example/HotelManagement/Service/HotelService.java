package com.example.HotelManagement.Service;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.http11.Http11InputBuffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	public ResponseEntity<Hotel> saveHotel(HotelDTO hotelDTO) {
		
		Hotel hotel = new Hotel();
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(hotelDTO.getCity());
		hotel.setPostalCode(hotelDTO.getPostalCode());
		hotel.setRating(hotelDTO.getRating());
		hotel.setAvailable(hotelDTO.isAvailable());
		
		hotelRepository.save(hotel);  
		return new ResponseEntity<Hotel>(hotel, HttpStatus.CREATED);
	}
	
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}
	
	public ResponseEntity<Hotel> getHotelById(Long id) {
		
		Optional<Hotel> hotelBox = hotelRepository.findById(id);
		
		if (hotelBox.isPresent()) {
			return new ResponseEntity<Hotel>(hotelBox.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Hotel>(HttpStatus.NO_CONTENT);
	}
	
	public ResponseEntity<Hotel> updateHotel(HotelDTO hotelDTO, Long id) {
		
		ResponseEntity<Hotel> response = getHotelById(id);
		Hotel hotel = response.getBody();
		
		if (hotel != null) {
			hotel.setName(hotelDTO.getName());
			hotel.setAddress(hotelDTO.getAddress());
			hotel.setCity(hotelDTO.getCity());
			hotel.setPostalCode(hotelDTO.getPostalCode());
			hotel.setRating(hotelDTO.getRating());
			hotel.setAvailable(hotelDTO.isAvailable());
			hotelRepository.save(hotel);
			return new ResponseEntity<Hotel>(hotel, HttpStatus.OK);
		}
		return new ResponseEntity<Hotel>(hotel, HttpStatus.NOT_FOUND);

	}
	
	public void deleteHotel(Long id) {
		
		Optional<Hotel> hotelBox = hotelRepository.findById(id);
		Hotel hotel = new Hotel();
		if (hotelBox.isPresent()) {
			hotel = hotelBox.get();
			hotelRepository.deleteById(id);
		}
		
	} 
	
	public Hotel updateHotelAddress(UpdateHotelAddressDTO updateHotelAddressDTO, Long id) {
	
		Optional<Hotel> hotelBox = hotelRepository.findById(id);
		Hotel hotel = new Hotel();
		
		if (hotelBox.isPresent()) {
			hotel = hotelBox.get();
			hotel.setAddress(updateHotelAddressDTO.getAddress());
			hotel.setCity(updateHotelAddressDTO.getCity());
			hotel.setPostalCode(updateHotelAddressDTO.getPostalCode());
			return hotelRepository.save(hotel);		
		}
		return hotel;
	}
	

}
