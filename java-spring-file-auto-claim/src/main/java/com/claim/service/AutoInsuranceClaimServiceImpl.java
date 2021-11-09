package com.claim.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.claim.dao.AutoInsuranceClaimRepository;
import com.claim.dao.entity.AutoInsuranceClaim;
import com.claim.dto.AutoInsuranceClaimDTO;
import com.claim.dto.AutoInsuranceClaimRequest;
import com.claim.mappers.AutoInsuranceMapper;

@Service
public class AutoInsuranceClaimServiceImpl implements AutoInsuranceService {

	private final AutoInsuranceClaimRepository repository;
	private final AutoInsuranceMapper mapper;

	public AutoInsuranceClaimServiceImpl(AutoInsuranceClaimRepository repository, AutoInsuranceMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public AutoInsuranceClaimDTO createClaim(AutoInsuranceClaimRequest insuranceClaimRequest) {
		AutoInsuranceClaim claim = this.mapper.map(insuranceClaimRequest);
		return Optional.of(this.repository.save(claim)).map(this.mapper::map).orElseThrow();
	}

}
