package com.BankingApplicationForSoumya.bank.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}