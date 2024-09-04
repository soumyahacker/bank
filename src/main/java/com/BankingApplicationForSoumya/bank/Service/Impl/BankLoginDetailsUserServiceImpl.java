package com.BankingApplicationForSoumya.bank.Service.Impl;

import com.BankingApplicationForSoumya.bank.Mapper.BankUserLoginMapper;
import com.BankingApplicationForSoumya.bank.Service.BankLoginDetailsUserService;
import com.BankingApplicationForSoumya.bank.dto.BankUserLoginDetailsDTO;
import com.BankingApplicationForSoumya.bank.entity.BankUserLoginDetails;
import com.BankingApplicationForSoumya.bank.repository.BankUserLoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankLoginDetailsUserServiceImpl implements BankLoginDetailsUserService {
@Autowired
    private BankUserLoginDetailsRepository bankUserLoginDetailsRepository;
    @Override
    public BankUserLoginDetailsDTO addLoginDetail(BankUserLoginDetailsDTO bankUserLoginDetails) {
        BankUserLoginMapper bankUserLoginMapper = new BankUserLoginMapper();

        BankUserLoginDetails bankUserLoginDetailsEnt = bankUserLoginMapper.loginDtotoEnt(bankUserLoginDetails);

        return bankUserLoginMapper.loginEnttoDto(bankUserLoginDetailsRepository.save(bankUserLoginDetailsEnt));



    }
}
