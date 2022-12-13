package com.mbs.mbsusermicroservice.service;

import com.mbs.mbsusermicroservice.dto.UserRequestDTO;
import com.mbs.mbsusermicroservice.dto.UserResponseDTO;
import com.mbs.mbsusermicroservice.entity.User;
import com.mbs.mbsusermicroservice.exception.ConflictException;
import com.mbs.mbsusermicroservice.repository.UserRepository;
import com.mbs.mbsusermicroservice.util.EncoderUtil;
import com.mbs.mbsusermicroservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private EncoderUtil encoderUtil;

    @Override
    public UserResponseDTO registration(UserRequestDTO request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setPassword(encoderUtil.encode(request.getPassword()));

        userRepository.findOneByEmail(request.getEmail()).ifPresent(c -> {
            throw new ConflictException("Email already in use.");
        });
        userRepository.findOneByPhone(request.getPhone()).ifPresent(c -> {
            throw new ConflictException("Phone already in use.");
        });
        User userEntity= userRepository.save(user);
        return entityToDTO(new UserResponseDTO(), userEntity);
    }

    private UserResponseDTO entityToDTO(UserResponseDTO dto, User entity) {
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        return dto;
    }
}
