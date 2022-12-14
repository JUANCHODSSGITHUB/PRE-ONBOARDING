package com.mbs.mbsaccountmicroservice.service;

import com.mbs.mbsaccountmicroservice.dto.AccountRequestDTO;
import com.mbs.mbsaccountmicroservice.dto.AccountResponseDTO;
import com.mbs.mbsaccountmicroservice.dto.AccountTransactionResponseDTO;
import org.bson.types.Decimal128;

public interface AccountService {
    AccountTransactionResponseDTO withdraw(String accountNumber, Decimal128 amount);
    AccountTransactionResponseDTO deposit(String accountNumber, Decimal128 amount);
    AccountTransactionResponseDTO withdrawConverted(String accountNumber, Decimal128 amount);
    AccountResponseDTO createAccount(AccountRequestDTO dto);

}
