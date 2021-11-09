package com.claim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.claim.dao.entity.AutoInsuranceClaim;

public interface AutoInsuranceClaimRepository extends JpaRepository<AutoInsuranceClaim, Long>{

}
