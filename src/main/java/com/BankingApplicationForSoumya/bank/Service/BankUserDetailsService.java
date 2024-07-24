package com.BankingApplicationForSoumya.bank.Service;

import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;

public interface BankUserDetailsService {

    abstract BankUsersdetailsDTO CreateAccountBank( BankUsersdetailsDTO bankUsersdetails);
    abstract BankUsersdetailsDTO getBankDetailsbyId(int id);

    abstract  BankUsersdetailsDTO depositMoney(double amount,int userId);


}
