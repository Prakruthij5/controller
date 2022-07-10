package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.dto.FlatBookingDto;
import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.serviceimpl.FlatBookingService;
import com.cg.ofr.serviceimpl.FlatService;


@RestController
@RequestMapping("/admin_user")
public class AdminAndUserController {

	

	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private FlatService flatService;
	
	
	
	@GetMapping("/flatId")
	public FlatDto viewFlatById(@PathVariable("flatId")Integer flatId) throws FlatNotFoundException {
		return flatService.viewFlat(flatId);
	}
	@GetMapping("/viewAllFlat")
	public List<FlatDto>viewAllFlat(){
		return flatService.viewAllFlat();
	}

	 
	 @DeleteMapping("/deleteFlatBooking/{id}")
	 
	  public FlatBookingDto deleteFlatBooking(@PathVariable("bookingNo") Integer bookingNo) throws FlatBookingNotFoundException 
	   { 
        return iflatbookingService.deleteFlatBooking(bookingNo); 
        }
	  
	  @GetMapping("/viewFlatBooking/{id}")
		 
	  public FlatBookingDto viewFlatBooking(@PathVariable("bookingNo") Integer bookingNo)throws FlatBookingNotFoundException
	   { 
        return iflatbookingService.viewFlatBooking(bookingNo); 
        }
	  
	  @GetMapping("/viewAllFlatBooking")
		public List<FlatBookingDto> getAllProducts() {
			
			return iflatbookingService.viewAllFlatBooking();
		}

	  
}
