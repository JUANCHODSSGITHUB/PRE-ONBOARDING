package com.mbs.mbsauthmicroservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

    private String email;
    private String password;
}
