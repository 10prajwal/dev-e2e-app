package com.claim.dto;

import java.time.LocalDateTime;

public class AutoInsuranceClaimRequest {
	private LocalDateTime accidentTime;
	private PolicyHolder policyHolder;
	
	public LocalDateTime getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(LocalDateTime accidentTime) {
		this.accidentTime = accidentTime;
	}
	public PolicyHolder getPolicyHolder() {
		return policyHolder;
	}
	public void setPolicyHolder(PolicyHolder policyHolder) {
		this.policyHolder = policyHolder;
	}
	
	
}
