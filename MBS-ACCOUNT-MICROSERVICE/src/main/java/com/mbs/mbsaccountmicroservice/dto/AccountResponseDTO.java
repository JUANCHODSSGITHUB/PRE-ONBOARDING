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
public class AccountResponseDTO {

    private String number;

    private String name;

    private Decimal128 balance;

    private String currency;

    private String userEmail;
}
