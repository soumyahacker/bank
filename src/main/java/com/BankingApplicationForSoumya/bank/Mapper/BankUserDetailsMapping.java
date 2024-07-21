package com.BankingApplicationForSoumya.bank.Mapper;

import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;

public class BankUserDetailsMapping {

    public static  BankUsersdetails MapToUserDetailtoentity(BankUsersdetailsDTO bankUsersdetailsDTO){
        BankUsersdetails bankUsersdetails = new BankUsersdetails();
        bankUsersdetails.setUserId(bankUsersdetailsDTO.getUserId());
        bankUsersdetails.setFirstName(bankUsersdetailsDTO.getFirstName());
        bankUsersdetails.setLastName(bankUsersdetailsDTO.getLastName());
        bankUsersdetails.setState(bankUsersdetailsDTO.getState());
        bankUsersdetails.setAccountNumber(bankUsersdetailsDTO.getAccountNumber());
        bankUsersdetails.setAccountType(bankUsersdetailsDTO.getAccountType());
        bankUsersdetails.setAnnualIncome(bankUsersdetailsDTO.getAnnualIncome());
        bankUsersdetails.setAccountBalance(bankUsersdetailsDTO.getAccountBalance());
        bankUsersdetails.setCountry(bankUsersdetailsDTO.getCountry());
        bankUsersdetails.setPhoneNumber(bankUsersdetailsDTO.getPhoneNumber());
        bankUsersdetails.setDateOfBirth(bankUsersdetailsDTO.getDateOfBirth());

        return bankUsersdetails;

    }

    public static BankUsersdetailsDTO MapToUserDetailtodto(BankUsersdetails bankUsersdetails){
        BankUsersdetailsDTO bankUsersdetailsDTO = new BankUsersdetailsDTO();
        bankUsersdetailsDTO.setAccountBalance(bankUsersdetails.getAccountBalance());
        bankUsersdetailsDTO.setAccountNumber(bankUsersdetails.getAccountNumber());
        bankUsersdetailsDTO.setAccountType(bankUsersdetails.getAccountType());
        bankUsersdetailsDTO.setCountry(bankUsersdetails.getCountry());
        bankUsersdetailsDTO.setAnnualIncome(bankUsersdetails.getAnnualIncome());
        bankUsersdetailsDTO.setState(bankUsersdetails.getState());
        bankUsersdetailsDTO.setPhoneNumber(bankUsersdetails.getPhoneNumber());
        bankUsersdetailsDTO.setDateOfBirth(bankUsersdetails.getDateOfBirth());
        bankUsersdetailsDTO.setUserId(bankUsersdetails.getUserId());
        bankUsersdetailsDTO.setFirstName(bankUsersdetails.getFirstName());
        bankUsersdetailsDTO.setLastName(bankUsersdetails.getLastName());
        return bankUsersdetailsDTO;
    }
}
