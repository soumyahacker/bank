package com.BankingApplicationForSoumya.bank.util;

import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.concurrent.CompletableFuture;

public class BankUserDetailsJsonParser {

    public BankUsersdetailsDTO getBankUserDetails() throws Exception{

        ObjectMapper mapper = new ObjectMapper();

        BankUsersdetailsDTO bankUsersdetailsDTO = mapper.readValue(new File("src/test/java/com/BankingApplicationForSoumya/bank/resources/BankUserdetails.json"),BankUsersdetailsDTO.class);



        return bankUsersdetailsDTO;
    }
}
