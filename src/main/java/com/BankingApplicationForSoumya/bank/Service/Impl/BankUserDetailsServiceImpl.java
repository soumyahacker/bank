package com.BankingApplicationForSoumya.bank.Service.Impl;

import com.BankingApplicationForSoumya.bank.Mapper.BankUserDetailsMapping;
import com.BankingApplicationForSoumya.bank.Service.BankUserDetailsService;
import com.BankingApplicationForSoumya.bank.dto.BankUsersdetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUsersdetails;
import com.BankingApplicationForSoumya.bank.exceptions.AccountNotFoundException;
import com.BankingApplicationForSoumya.bank.repository.BankUserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankUserDetailsServiceImpl implements BankUserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(BankUserDetailsServiceImpl.class);

    private BankUserDetailsRepository bankUserDetailsRepository;

    public BankUserDetailsServiceImpl(BankUserDetailsRepository bankUserDetailsRepository) {
        this.bankUserDetailsRepository = bankUserDetailsRepository;
    }

    public BankUsersdetailsDTO CreateAccountBank(BankUsersdetailsDTO bankUsersdetails) {
        logger.info("Creating a new bank account for user: {}", bankUsersdetails.getUserId());
        BankUsersdetails bankUsersdetails1 = BankUserDetailsMapping.MapToUserDetailtoentity(bankUsersdetails);
        BankUsersdetails SavedBankuserDetails = bankUserDetailsRepository.save(bankUsersdetails1);
        logger.info("Bank account created successfully for user: {}", bankUsersdetails.getUserId());
        return BankUserDetailsMapping.MapToUserDetailtodto(SavedBankuserDetails);
    }

    @Override
    public BankUsersdetailsDTO getBankDetailsbyId(int userId) {
        logger.info("Fetching bank details for userId: {}", userId);
        BankUsersdetails bankUsersdetails = bankUserDetailsRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + userId + " does not exist"));
        logger.info("Bank details fetched successfully for userId: {}", userId);
        //logger.info(bankUsersdetails);
        return BankUserDetailsMapping.MapToUserDetailtodto(bankUsersdetails);
    }

    @Override
    public BankUsersdetailsDTO depositMoney(double amount, int userId) {
        logger.info("Depositing money into account of userId: {}", userId);
        BankUsersdetails bankUsersdetails = bankUserDetailsRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + userId + " does not exist"));
        double totalBalance = bankUsersdetails.getAccountBalance() + amount;
        bankUsersdetails.setAccountBalance(totalBalance);
        BankUsersdetails SavedBankuserDetails = bankUserDetailsRepository.save(bankUsersdetails);
        logger.info("Amount {} successfully deposited. New balance: {}", amount, totalBalance);
        return BankUserDetailsMapping.MapToUserDetailtodto(SavedBankuserDetails);
    }

    @Override
    public BankUsersdetailsDTO deleteBankDetailsbyID(int userId) {
        logger.info("Deleting bank account for userId: {}", userId);
        BankUsersdetails bankUsersdetails = bankUserDetailsRepository.findById(userId)
                .orElseThrow(() -> new AccountNotFoundException("Account with ID " + userId + " does not exist"));
        BankUsersdetailsDTO userDTO = BankUserDetailsMapping.MapToUserDetailtodto(bankUsersdetails);
        bankUserDetailsRepository.deleteById(userId);
        logger.info("Bank account with userId: {} successfully deleted", userId);
        return userDTO;
    }
}
