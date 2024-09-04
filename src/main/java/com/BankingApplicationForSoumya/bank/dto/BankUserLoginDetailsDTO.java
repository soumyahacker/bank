package com.BankingApplicationForSoumya.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class BankUserLoginDetailsDTO {


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    @JsonProperty("userId")
    private int userId;

    @JsonProperty("Username")
      private String Username;
    @JsonProperty("Password")
      private String Password;


}
