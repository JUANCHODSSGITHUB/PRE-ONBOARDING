package com.mbs.mbsusermicroservice.controller;

import com.mbs.mbsusermicroservice.dto.UserRequestDTO;
import com.mbs.mbsusermicroservice.dto.UserResponseDTO;
import com.mbs.mbsusermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserResponseDTO> registration(@Valid @RequestBody UserRequestDTO request) {
        return new ResponseEntity<>(userService.registration(request), HttpStatus.CREATED);
    }
}
