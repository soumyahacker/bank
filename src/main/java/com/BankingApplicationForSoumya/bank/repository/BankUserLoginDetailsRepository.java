package com.BankingApplicationForSoumya.bank.repository;

import com.BankingApplicationForSoumya.bank.entity.BankUserLoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserLoginDetailsRepository extends JpaRepository<BankUserLoginDetails,Integer> {
}
