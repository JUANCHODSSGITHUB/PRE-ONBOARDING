package com.mbs.mbsaccountmicroservice.controller;

import com.mbs.mbsaccountmicroservice.dto.AccountRequestDTO;
import com.mbs.mbsaccountmicroservice.dto.AccountResponseDTO;
import com.mbs.mbsaccountmicroservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> registration(@Valid @RequestBody AccountRequestDTO request) {
        return new ResponseEntity<>(accountService.createAccount(request), HttpStatus.CREATED);
    }
}
