package com.BankingApplicationForSoumya.bank.Mapper;

import com.BankingApplicationForSoumya.bank.dto.BankUserLoginDetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUserLoginDetails;

public class BankUserLoginMapper {

    public BankUserLoginDetails loginDtotoEnt (BankUserLoginDetailsDTO bankUserLoginDetailsDTO){
        BankUserLoginDetails bankUserLoginDetails = new BankUserLoginDetails();
        bankUserLoginDetails.setPassword(bankUserLoginDetailsDTO.getPassword());
        bankUserLoginDetails.setUsername(bankUserLoginDetailsDTO.getUsername());
        bankUserLoginDetails.setUserId(bankUserLoginDetailsDTO.getUserId());
        return bankUserLoginDetails;
    }

    public BankUserLoginDetailsDTO loginEnttoDto (BankUserLoginDetails bankUserLoginDetails){
        BankUserLoginDetailsDTO bankUserLoginDetailsDTO= new BankUserLoginDetailsDTO();
        bankUserLoginDetailsDTO.setPassword(bankUserLoginDetails.getPassword());
        bankUserLoginDetailsDTO.setUsername(bankUserLoginDetails.getUsername());
        bankUserLoginDetailsDTO.setUserId(bankUserLoginDetails.getUserId());
        return bankUserLoginDetailsDTO;

    }
}
