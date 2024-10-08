package com.BankingApplicationForSoumya.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence .Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;


public class BankUsersdetailsDTO {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonProperty("userId")
    private int userId;

    @JsonProperty("firstName")
    private String firstName;


    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("dateOfBirth")
    private LocalDate dateOfBirth;


    @JsonProperty("state")
    private String state;  // Renamed to avoid potential conflict

    @JsonProperty("country")
    private String country;

    @JsonProperty("phoneNumber")
    private String phoneNumber;


    @JsonProperty("accountNumber")
    private String accountNumber;

    @JsonProperty("accountType")
    private String accountType;

    @JsonProperty("accountBalance")
    private double accountBalance;

    @JsonProperty("annualIncome")
    private double annualIncome;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankUsersdetailsDTO that = (BankUsersdetailsDTO) o;
        return userId == that.userId && Double.compare(accountBalance, that.accountBalance) == 0 && Double.compare(annualIncome, that.annualIncome) == 0 && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(state, that.state) && Objects.equals(country, that.country) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountType, that.accountType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, dateOfBirth, state, country, phoneNumber, accountNumber, accountType, accountBalance, annualIncome);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome) {
        this.annualIncome = annualIncome;
    }
}