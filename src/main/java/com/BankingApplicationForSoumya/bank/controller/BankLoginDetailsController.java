package com.BankingApplicationForSoumya.bank.controller;


import com.BankingApplicationForSoumya.bank.Service.BankLoginDetailsUserService;
import com.BankingApplicationForSoumya.bank.dto.BankUserLoginDetailsDTO;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUserLoginDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class BankLoginDetailsController {

    private final BankLoginDetailsUserService bankLoginDetailsUserService;

    public BankLoginDetailsController(BankLoginDetailsUserService bankLoginDetailsUserService) {
        this.bankLoginDetailsUserService = bankLoginDetailsUserService;
    }

    @PostMapping("/createlogin")
    public ResponseEntity<BankUserLoginDetailsDTO> CreateLogin(@RequestBody BankUserLoginDetailsDTO bankUserLoginDetailsdto){

        BankUserLoginDetailsDTO savedLogin = bankLoginDetailsUserService.addLoginDetail(bankUserLoginDetailsdto);



        return new ResponseEntity<>(savedLogin, HttpStatus.CREATED);
    }
}
