package com.claim.dto;

import java.time.LocalDateTime;

public class AutoInsuranceClaimDTO {

	private Long claimId;
	private LocalDateTime accidentTime;
	private PolicyHolder policyHolder;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

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
