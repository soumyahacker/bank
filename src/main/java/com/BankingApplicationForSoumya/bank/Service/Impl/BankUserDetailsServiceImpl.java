package com.BankingApplicationForSoumya.bank.Service.Impl;

import com.BankingApplicationForSoumya.bank.Mapper.BankUserDetailsMapping;
import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import com.BankingApplicationForSoumya.bank.repository.BankUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankUserDetailsServiceImpl implements BankUserDetailsService {


    public BankUserDetailsServiceImpl(BankUserDetailsRepository bankUserDetailsRepository) {
        this.bankUserDetailsRepository = bankUserDetailsRepository;
    }

    private BankUserDetailsRepository bankUserDetailsRepository;

    public BankUsersdetailsDTO CreateAccountBank(BankUsersdetailsDTO bankUsersdetails) {

        BankUsersdetails bankUsersdetails1 = BankUserDetailsMapping.MapToUserDetailtoentity(bankUsersdetails);
        BankUsersdetails SavedBankuserDetails =  bankUserDetailsRepository.save(bankUsersdetails1);

        return BankUserDetailsMapping.MapToUserDetailtodto(bankUsersdetails1);
    }
}
