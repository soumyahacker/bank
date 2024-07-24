package com.BankingApplicationForSoumya.bank.controller;


import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/api/bankuserdetails")
public class BankController {

    private BankUserDetailsService bankUserDetailsService;

    public BankController(BankUserDetailsService bankUserDetailsService) {
        this.bankUserDetailsService = bankUserDetailsService;
    }


    @PostMapping("/create")
    public ResponseEntity<BankUsersdetailsDTO> addAccount(@RequestBody BankUsersdetailsDTO bankUsersdetailsDTO){

        return new ResponseEntity<>(bankUserDetailsService.CreateAccountBank(bankUsersdetailsDTO), HttpStatus.CREATED);
    }

    @GetMapping("/search/{userId}")
    public ResponseEntity<BankUsersdetailsDTO> SearchAccountbyID(@PathVariable int userId){
        BankUsersdetailsDTO bankUsersdetailsDTO= bankUserDetailsService.getBankDetailsbyId(userId);

        return ResponseEntity.ok(bankUsersdetailsDTO);
    }

    @PutMapping("/deposit/{userId}")
    public ResponseEntity<BankUsersdetailsDTO> depositMoneyToBank(@RequestBody Map<String, Double> request, @PathVariable int userId) {
        // Extract amount from the request map
        Double amount = request.get("amount");

        // Call the service method to deposit money
        BankUsersdetailsDTO bankUsersdetailsDTO = bankUserDetailsService.depositMoney(amount, userId);

        // Return the response
        return ResponseEntity.ok(bankUsersdetailsDTO);
    }



}
