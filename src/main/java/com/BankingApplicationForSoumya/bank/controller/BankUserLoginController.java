package com.BankingApplicationForSoumya.bank.controller;

import com.BankingApplicationForSoumya.bank.Service.CustomUserDetailsService;
import com.BankingApplicationForSoumya.bank.Service.loginservice;
import com.BankingApplicationForSoumya.bank.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/security")
public class BankUserLoginController {
    @Autowired
private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private loginservice loginservice;
    @PostMapping("/registerUser")

    public ResponseEntity<Users> RegisterUser(@RequestBody Users user){

Users SavedUser = customUserDetailsService.Register(user);
        return new ResponseEntity<>(SavedUser,HttpStatus.CREATED);
    }

    @PostMapping("/LoginUser")
    public String LoginUser(@RequestBody Users user){


        return loginservice.LoginUser(user);
    }


}
