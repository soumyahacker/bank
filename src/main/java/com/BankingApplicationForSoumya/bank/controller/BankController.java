package com.BankingApplicationForSoumya.bank.controller;


import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


}
