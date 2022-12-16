package com.mbs.mbsauthmicroservice.controller;

import com.mbs.mbsauthmicroservice.dto.LoginResponseDTO;
import com.mbs.mbsauthmicroservice.dto.UserLoginDTO;
import com.mbs.mbsauthmicroservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody UserLoginDTO login) {
        return new ResponseEntity<>(authService.login(login), HttpStatus.OK);
    }
}
