package com.mbs.mbsaccountmicroservice.service;

import com.mbs.mbsaccountmicroservice.dto.AccountRequestDTO;
import com.mbs.mbsaccountmicroservice.dto.AccountResponseDTO;
import com.mbs.mbsaccountmicroservice.dto.AccountTransactionResponseDTO;
import com.mbs.mbsaccountmicroservice.entity.Account;
import com.mbs.mbsaccountmicroservice.exception.ConflictException;
import com.mbs.mbsaccountmicroservice.repository.AccountRepository;
import com.mbs.mbsaccountmicroservice.util.AcctNumberGeneratorUtil;
import com.mbs.mbsaccountmicroservice.util.EncoderUtil;
import org.bson.types.Decimal128;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    AcctNumberGeneratorUtil acctNumberGeneratorUtil;

    @Override
    public AccountTransactionResponseDTO withdraw(String accountNumber, Decimal128 amount) {
        return null;
    }

    @Override
    public AccountTransactionResponseDTO deposit(String accountNumber, Decimal128 amount) {
        return null;
    }

    @Override
    public AccountTransactionResponseDTO withdrawConverted(String accountNumber, Decimal128 amount) {
        return null;
    }

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO dto) {
        Account account = new Account();
        account.setNumber(acctNumberGeneratorUtil.generateNumber());
        account.setName(dto.getName());
        account.setPin(encoderUtil.encode(dto.getPin()));
        account.setBalance(dto.getBalance());
        account.setUserEmail(dto.getUserEmail());
        account.setCurrency(dto.getCurrency());

        if(accountRepository.findOneByName(dto.getName())==null){
            Account newAccount = accountRepository.save(account);
            return entityToDTO(newAccount);
        }else{
            throw new ConflictException("Account name already exists.");
        }

    }


    private AccountResponseDTO entityToDTO( Account entity) {

        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setName(entity.getName());
        dto.setNumber(entity.getNumber());
        dto.setUserEmail(entity.getUserEmail());
        dto.setBalance(entity.getBalance());
        dto.setCurrency(entity.getCurrency());
        return dto;
    }



}
