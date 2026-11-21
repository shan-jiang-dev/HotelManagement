package com.example.HotelManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;

@RestController
public class HotelController {
	
	@Autowired
	HotelService hotelService;

	// @RequestBody: De-serialize JSON data(send in request by Postman) to java object
	
	@PostMapping
	public Hotel createHotel(@RequestBody HotelDTO hotelDTO) {
		
		return hotelService.saveHotel(hotelDTO);
		
	}
}
