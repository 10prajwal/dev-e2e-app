package com.claim.mappers;

import org.springframework.stereotype.Component;

import com.claim.dao.entity.AutoInsuranceClaim;
import com.claim.dto.AutoInsuranceClaimDTO;
import com.claim.dto.AutoInsuranceClaimRequest;
import com.claim.dto.PolicyHolder;

@Component
public class AutoInsuranceMapper {

	public AutoInsuranceClaimDTO map(AutoInsuranceClaim claimEntity) {
		if (claimEntity == null) {
			return null;
		}

		AutoInsuranceClaimDTO autoInsuranceClaimDTO = new AutoInsuranceClaimDTO();

		autoInsuranceClaimDTO.setPolicyHolder(autoInsuranceClaimToPolicyHolder(claimEntity));
		autoInsuranceClaimDTO.setAccidentTime(claimEntity.getAccidentTime());
		autoInsuranceClaimDTO.setClaimId(claimEntity.getId());

		return autoInsuranceClaimDTO;
	}

	public AutoInsuranceClaim map(AutoInsuranceClaimRequest request) {
		if (request == null) {
			return null;
		}

		AutoInsuranceClaim autoInsuranceClaim = new AutoInsuranceClaim();

		autoInsuranceClaim.setAccidentTime(request.getAccidentTime());
		autoInsuranceClaim.setFirstName(requestPolicyHolderFirstName(request));
		autoInsuranceClaim.setEmailAddress(requestPolicyHolderEmailAddress(request));

		return autoInsuranceClaim;
	}

	protected PolicyHolder autoInsuranceClaimToPolicyHolder(AutoInsuranceClaim autoInsuranceClaim) {
		if (autoInsuranceClaim == null) {
			return null;
		}

		PolicyHolder policyHolder = new PolicyHolder();

		policyHolder.setFirstName(autoInsuranceClaim.getFullName());
		policyHolder.setEmailAddress(autoInsuranceClaim.getEmailAddress());

		return policyHolder;
	}

	private String requestPolicyHolderFirstName(AutoInsuranceClaimRequest autoInsuranceClaimRequest) {
		if (autoInsuranceClaimRequest == null) {
			return null;
		}
		PolicyHolder policyHolder = autoInsuranceClaimRequest.getPolicyHolder();
		if (policyHolder == null) {
			return null;
		}
		String firstName = policyHolder.getFullName();
		if (firstName == null) {
			return null;
		}
		return firstName;
	}

	private String requestPolicyHolderEmailAddress(AutoInsuranceClaimRequest autoInsuranceClaimRequest) {
		if (autoInsuranceClaimRequest == null) {
			return null;
		}
		PolicyHolder policyHolder = autoInsuranceClaimRequest.getPolicyHolder();
		if (policyHolder == null) {
			return null;
		}
		String emailAddress = policyHolder.getEmailAddress();
		if (emailAddress == null) {
			return null;
		}
		return emailAddress;
	}
}
