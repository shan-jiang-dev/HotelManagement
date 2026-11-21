package com.example.HotelManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.DTO.HotelDTO;
import com.example.HotelManagement.DTO.UpdateHotelAddressDTO;
import com.example.HotelManagement.Entity.Hotel;
import com.example.HotelManagement.Service.HotelService;


@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;

	// @RequestBody: De-serialize JSON data(post request from Postman) to java object
	
	@PostMapping("/createhotel")
	public Hotel createHotel(@RequestBody HotelDTO hotelDTO) {
		
		return hotelService.saveHotel(hotelDTO);
		
	}
	
	@GetMapping("/getallhotels")
	public List<Hotel> getAllHotels() {
		return hotelService.getAllHotels();
	}
	
	@GetMapping("/gethotel/{id}")
	public Hotel getHotelById(@PathVariable Long id) {
		
		return hotelService.getHotelById(id);
		
	}
	
	@PutMapping("/updatehotel/{id}")
	public Hotel updateHotel(@RequestBody HotelDTO hotelDTO, @PathVariable Long id) {
		
		return hotelService.updateHotel(hotelDTO, id);
	}
	
	@DeleteMapping("/deletehotel/{id}")
	public void deleteHotel(@PathVariable Long id) {
		
		hotelService.deleteHotel(id);
	}
	
	@PutMapping("/updatehoteladdress/{id}")
	public Hotel updateHotelAddress(@RequestBody UpdateHotelAddressDTO updateHotelAddressDTO, @PathVariable Long id) {
		return hotelService.updateHotelAddress(updateHotelAddressDTO, id);
		
	}
	
}
