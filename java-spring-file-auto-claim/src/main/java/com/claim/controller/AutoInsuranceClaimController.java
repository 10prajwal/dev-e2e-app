package com.claim.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claim.dto.AutoInsuranceClaimDTO;
import com.claim.dto.AutoInsuranceClaimRequest;
import com.claim.service.AutoInsuranceService;

@RestController
@RequestMapping("auto-claims")
public class AutoInsuranceClaimController {

	private final AutoInsuranceService service;

	public AutoInsuranceClaimController(AutoInsuranceService service) {
		super();
		this.service = service;
	}
	
	/**
	 * Creates a new claim <code>POST /api/claim-management/auto-claims</code> and returns the claim reference ID
	 * @param request
	 * @return
	 */
	@CrossOrigin(origins = "*")
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AutoInsuranceClaimDTO> createClaim(@RequestBody() AutoInsuranceClaimRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createClaim(request));
	}

}
