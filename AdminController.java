package com.cg.ofr.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.dto.FlatBookingDto;
import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.dto.LandlordDto;
import com.cg.ofr.dto.TenantDto;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.service.IFlatService;
import com.cg.ofr.serviceimpl.FlatBookingService;
import com.cg.ofr.serviceimpl.LandlordService;
import com.cg.ofr.serviceimpl.TenantService;

@RestController

public class AdminController {

	
	@Autowired
	private LandlordService ilandlordservice;
	
	@Autowired
	private TenantService itenantservice;
	
	@Autowired
	private FlatBookingService iflatbookingService;
	
	@Autowired
	private IFlatService iflatService;
	
	@Autowired
	private TenantService itenantService;
	
	
	
	  @PostMapping ("/addLandlord")
	  public LandlordDto addLandlord(@RequestBody LandlordDto landlordDto) {
	 
	  return ilandlordservice.addLandlord(landlordDto); 
	  }
	 
	
	
	@PutMapping("/updatelandlord/{id}/{newLandlordName}")
	public LandlordDto updateLandlord(@PathVariable("id") Integer landlordId,@PathVariable("newLandlordName") String landlordName ) throws LandlordNotFoundException{
		return ilandlordservice.updateLandlord(landlordId, landlordName);
		
	}
	
	@DeleteMapping("/deleteLandlord/{id}")
	public LandlordDto deleteLandlord(@PathVariable ("id") Integer landlordId) throws LandlordNotFoundException{
		return ilandlordservice.deleteLandlord(landlordId);
	}
	
	@PostMapping("/addTenant")
	public TenantDto addTenant(@RequestBody TenantDto tenantDto) {
		return itenantservice.addTenant(tenantDto);
	}
	
	@PutMapping("/updateTenant/{tenant_id}/{age}")
	public TenantDto updateTenant(@PathVariable("tenant_id") int tenant_id,@PathVariable("Age") int Age) throws TenantNotFoundException  {
		return itenantservice.updateTenant(tenant_id,Age);
	}
	
	@DeleteMapping("/deleteTenant/{tenant_id}")
	public TenantDto  deleteTenant(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException  {
		return itenantservice.deleteTenant(tenant_id);
	}
	
	@PostMapping("/addFlatBooking")
	public FlatBookingDto addFlatBooking(@RequestBody FlatBookingDto flatbookingDto){
		
		return iflatbookingService.addFlatBooking(flatbookingDto);
	}
	
	 @PutMapping("/updateFlatBooking/{id}/{localdate}")
	 
	  public FlatBookingDto updateFlatBooking(@PathVariable("bookingNo") int bookingNo,@PathVariable("localdate") LocalDate bookingFromDate )throws FlatBookingNotFoundException
	   { 
        return iflatbookingService.updateFlatBooking(bookingNo, bookingFromDate); 
        }
	 

	 @PostMapping("/addFlat")
		public FlatDto addFlat(@RequestBody FlatDto flatDto) {
			return iflatService.addFlat(flatDto);
		}
		
		@PutMapping("/flatId/{newcost}")
		public FlatDto updateCost(@PathVariable("flatId")Integer flatId,@PathVariable("newCost")Double cost) throws FlatNotFoundException {
			return iflatService.updateFlat(flatId,cost);
		}
		@DeleteMapping("/flatId")
		public FlatDto deleteFlat(@PathVariable("flatId")Integer flatId) throws FlatNotFoundException{
		
			return iflatService.deleteFlat(flatId);
		}
	 
	 @GetMapping("/validateTenantById/{tenant_id}")
		public TenantDto validateTenantById(@PathVariable("tenant_id") int tenant_Id) {
			return itenantService. validateTenantById(tenant_Id);
		}

	 
}
