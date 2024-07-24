package com.BankingApplicationForSoumya.bank.Service.Impl;

import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.controller.BankController;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import com.BankingApplicationForSoumya.bank.util.BankUserDetailsJsonParser;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


class BankUserDetailsServiceImplTest {

    @InjectMocks
    BankUserDetailsService bankUserDetailsService;

    //@InjectMocks
    @Autowired
    BankController bankController;

    @Test
    public void Userdetailsinserttest() throws Exception{

        BankUsersdetailsDTO user = getBankUsersdetailsDTO();

        //Mockito.when(bankUserDetailsService.CreateAccountBank(Mockito.any(BankUsersdetailsDTO.class))).thenReturn(user);
        BankUserDetailsJsonParser bankUserDetailsJsonParser = new BankUserDetailsJsonParser();
        BankUsersdetailsDTO Expected  = bankUserDetailsJsonParser.getBankUserDetails();

        assertEquals(user,Expected);


    }

    private static BankUsersdetailsDTO getBankUsersdetailsDTO() {
        BankUsersdetailsDTO user = new BankUsersdetailsDTO();
        user.setUserId(11); // Assuming you want to use int and not String
        user.setFirstName("Soumya");
        user.setLastName("Pokale");
        user.setDateOfBirth(LocalDate.parse("2000-12-21"));
        user.setState("Maharashtra");
        user.setCountry("India");
        user.setPhoneNumber("9049622586");
        user.setAccountNumber("678901234597");
        user.setAccountType("Current");
        user.setAccountBalance(58000.0);
        user.setAnnualIncome(39000.0);
        return user;
    }

//    @Test
//    public  void  TestSearchBankAccount(){
//        BankUsersdetailsDTO actual = getBankUsersdetailsDTO();
//        when(bankUserDetailsService.getBankDetailsbyId(1)).thenReturn(actual);
//        BankUsersdetailsDTO expected = bankController.SearchAccountbyID(11).getBody();
//        assertEquals(expected,actual);
//
//    }


}