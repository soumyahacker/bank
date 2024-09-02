package com.BankingApplicationForSoumya.bank.Service.Impl;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.BankingApplicationForSoumya.bank.Mapper.BankUserDetailsMapping;
import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.controller.BankController;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import com.BankingApplicationForSoumya.bank.repository.BankUserDetailsRepository;
import com.BankingApplicationForSoumya.bank.util.BankUserDetailsJsonParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankUserDetailsServiceImplTest {

    @Mock
    private BankUserDetailsRepository bankUserDetailsRepository;

    @Mock
    private BankUserDetailsService bankUserDetailsService;

    @InjectMocks
    private BankController bankController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void Userdetailsinserttest() throws Exception {
        BankUsersdetailsDTO user = getBankUsersdetailsDTO();

        BankUserDetailsJsonParser bankUserDetailsJsonParser = new BankUserDetailsJsonParser();
        BankUsersdetailsDTO expected = bankUserDetailsJsonParser.getBankUserDetails();

        assertEquals(user, expected);
    }

    private static BankUsersdetailsDTO getBankUsersdetailsDTO() {
        BankUsersdetailsDTO user = new BankUsersdetailsDTO();
        user.setUserId(11);
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

    @Test
    public void TestSearchBankAccount() {
        BankUsersdetailsDTO actual = getBankUsersdetailsDTO();
        BankUsersdetails bankUsersdetails = BankUserDetailsMapping.MapToUserDetailtoentity(actual);

        when(bankUserDetailsRepository.findById(11)).thenReturn(Optional.of(bankUsersdetails));
        when(bankUserDetailsService.getBankDetailsbyId(11)).thenReturn(actual);

        BankUsersdetailsDTO expected = bankController.searchAccountByID(11).getBody();

        assertEquals(expected, actual);
    }

    @Test
    public  void UpdateBankAccount(){
        Map<String, Double> mockRequest = new HashMap<>();
        mockRequest.put("userId", 11.0);
        mockRequest.put("amount", 1100.0);
        double amount = 1100;
        BankUsersdetailsDTO actual = getBankUsersdetailsDTO();
        BankUsersdetails bankUsersdetails = BankUserDetailsMapping.MapToUserDetailtoentity(actual);
        bankUsersdetails.setAccountBalance(bankUsersdetails.getAccountBalance() + amount);

        when(bankUserDetailsRepository.findById(11)).thenReturn(Optional.of(bankUsersdetails));
        when(bankUserDetailsService.depositMoney(amount,11)).thenReturn(actual);
        BankUsersdetailsDTO expected = bankController.depositMoneyToBank(mockRequest,11).getBody();
        expected.setAccountBalance(expected.getAccountBalance() + amount);
        assertEquals(bankUsersdetails.getAccountBalance(),expected.getAccountBalance());
    }


}
