package com.BankingApplicationForSoumya.bank.Service.Impl;

import com.BankingApplicationForSoumya.bank.Mapper.BankUserDetailsMapping;
import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import com.BankingApplicationForSoumya.bank.repository.BankUserDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class BankUserDetailsServiceImpl implements BankUserDetailsService {


    public BankUserDetailsServiceImpl(BankUserDetailsRepository bankUserDetailsRepository) {
        this.bankUserDetailsRepository = bankUserDetailsRepository;
    }

    private BankUserDetailsRepository bankUserDetailsRepository;

    public BankUsersdetailsDTO CreateAccountBank(BankUsersdetailsDTO bankUsersdetails) {

        BankUsersdetails bankUsersdetails1 = BankUserDetailsMapping.MapToUserDetailtoentity(bankUsersdetails);
        BankUsersdetails SavedBankuserDetails =  bankUserDetailsRepository.save(bankUsersdetails1);

        return BankUserDetailsMapping.MapToUserDetailtodto(bankUsersdetails1);
    }

    @Override
    public BankUsersdetailsDTO getBankDetailsbyId(int userId) {

        BankUsersdetails bankUsersdetails = bankUserDetailsRepository.findById(userId).orElseThrow(()-> new RuntimeException("Account doesnt exist"));

        return BankUserDetailsMapping.MapToUserDetailtodto(bankUsersdetails);
    }

    @Override
    public BankUsersdetailsDTO depositMoney(double amount, int userId) {
        BankUsersdetails bankUsersdetails = bankUserDetailsRepository.findById(userId).orElseThrow(()-> new RuntimeException("Account doesnt exist"));
        double totalBalance = bankUsersdetails.getAccountBalance() + amount;
        bankUsersdetails.setAccountBalance(totalBalance);
        BankUsersdetails SavedBankuserDetails =bankUserDetailsRepository.save(bankUsersdetails);
        return BankUserDetailsMapping.MapToUserDetailtodto(SavedBankuserDetails);
    }

    @Override
    public BankUsersdetailsDTO deleteBankDetailsbyID(int userId) {
        BankUsersdetails user = bankUserDetailsRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        //
        BankUsersdetailsDTO userDTO = BankUserDetailsMapping.MapToUserDetailtodto(user);


        bankUserDetailsRepository.deleteById(userId);
        return userDTO;

    }




}
