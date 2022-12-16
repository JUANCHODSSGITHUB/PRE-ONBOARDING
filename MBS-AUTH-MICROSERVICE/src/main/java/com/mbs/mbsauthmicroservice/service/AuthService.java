package com.mbs.mbsauthmicroservice.service;

import com.mbs.mbsauthmicroservice.dto.LoginResponseDTO;
import com.mbs.mbsauthmicroservice.dto.UserLoginDTO;

public interface AuthService {

    LoginResponseDTO login(UserLoginDTO login);
}
