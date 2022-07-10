package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.dto.TenantDto;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.serviceimpl.TenantService;

@RestController
public class TenantController {
	
	@Autowired
	private TenantService itenantService;
	

	@GetMapping("/viewTenantById/{tenant_id}")
	public TenantDto viewTenantById(@PathVariable("tenant_id") int tenant_id) throws TenantNotFoundException {
		return itenantService.viewTenant(tenant_id);
	}
	@GetMapping("/viewAllTenant")
	public List<TenantDto> viewAllTenant() {
		return itenantService.viewAllTenant();
	}
	

}

	


