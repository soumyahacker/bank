package com.BankingApplicationForSoumya.bank.repository;

import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserDetailsRepository extends JpaRepository<BankUsersdetails ,Integer>{

}
