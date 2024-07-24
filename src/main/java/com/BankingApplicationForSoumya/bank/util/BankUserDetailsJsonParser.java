package com.BankingApplicationForSoumya.bank.util;

import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.util.concurrent.CompletableFuture;

public class BankUserDetailsJsonParser {

    public BankUsersdetailsDTO getBankUserDetails() throws Exception{

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        BankUsersdetailsDTO bankUsersdetailsDTO = mapper.readValue(new File("src/test/java/com/BankingApplicationForSoumya/bank/resources/BankUserdetails.json"),BankUsersdetailsDTO.class);



        return bankUsersdetailsDTO;
    }
}
