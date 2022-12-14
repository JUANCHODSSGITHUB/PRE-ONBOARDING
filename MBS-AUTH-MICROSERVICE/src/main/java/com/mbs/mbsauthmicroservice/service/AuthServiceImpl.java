package com.mbs.mbsauthmicroservice.service;

import com.mbs.mbsauthmicroservice.dto.LoginResponseDTO;
import com.mbs.mbsauthmicroservice.dto.UserLoginDTO;
import com.mbs.mbsauthmicroservice.entity.User;
import com.mbs.mbsauthmicroservice.exception.InvalidCredentialsException;
import com.mbs.mbsauthmicroservice.exception.NullCredentialsException;
import com.mbs.mbsauthmicroservice.repository.UserRepository;
import com.mbs.mbsauthmicroservice.util.EncoderUtil;
import com.mbs.mbsauthmicroservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncoderUtil encoderUtil;

    @Autowired
    private TokenUtil tokenUtil;


    @Override
    public LoginResponseDTO login(UserLoginDTO login) {
        Optional<User> user = userRepository.findOneByEmail(login.getEmail());
        if (login.getEmail().isBlank() || login.getPassword().isBlank() ) {
            throw new NullCredentialsException("Please input your email/password");
        }
        if (user.isPresent()) {
            User savedUser = user.get();
            if (encoderUtil.verify(login.getPassword(), savedUser.getPassword())) {
                String token = tokenUtil.generateToken(savedUser);
                LoginResponseDTO response = new LoginResponseDTO();
                response.setAccessToken(token);
                response.setStatus("Success");
                return response;
            } else {
                throw new InvalidCredentialsException();
            }
        } else throw new  InvalidCredentialsException();
    }
}
