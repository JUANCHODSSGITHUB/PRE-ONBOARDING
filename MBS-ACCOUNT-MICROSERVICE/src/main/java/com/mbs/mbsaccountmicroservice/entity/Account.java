package com.mbs.mbsaccountmicroservice.entity;


import lombok.*;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Document("accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String id;

    @NotBlank
    private String number;

    @NotBlank
    private String name;

    @NotBlank
    private String pin;

    @NotBlank
    private Decimal128 balance;

    @NotBlank
    private String currency;

    @NotBlank
    @Email
    private String userEmail;
}
