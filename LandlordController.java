package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.dto.LandlordDto;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.serviceimpl.LandlordService;

@RestController
@RequestMapping("/Landlord")
public class LandlordController {

	@Autowired
	private LandlordService ilandlordService;
	
	
	@GetMapping("/viewLandlordById/{id}")
	public LandlordDto viewLandlordById(@PathVariable("id") Integer landlordId) throws LandlordNotFoundException{
		return ilandlordService.viewLandlord(landlordId);
		
	}
	
	@GetMapping("/viewAllLandlord")
	public List<LandlordDto> viewAllLandlord(){
	 return ilandlordService.viewAllLandlord();
	}
	
}

