package com.claim.service;

import com.claim.dto.AutoInsuranceClaimDTO;
import com.claim.dto.AutoInsuranceClaimRequest;

public interface AutoInsuranceService {
	
	/**
	 * Create a claim for the Auto Insurance
	 * @param claimDetails
	 * @return
	 */
	public AutoInsuranceClaimDTO createClaim(AutoInsuranceClaimRequest claimDetails);
	
}
