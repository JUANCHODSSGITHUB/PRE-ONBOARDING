package com.mbs.mbsusermicroservice.service;

import com.mbs.mbsusermicroservice.dto.UserRequestDTO;
import com.mbs.mbsusermicroservice.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO registration(UserRequestDTO request);
}
