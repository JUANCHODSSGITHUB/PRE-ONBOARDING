package com.mbs.mbsaccountmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.Decimal128;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransactionResponseDTO {
    private String number;
    private Decimal128 balance;
}
