package com.mbs.mbsusermicroservice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncoderUtil {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encode(String raw) { return passwordEncoder.encode(raw);}
}
