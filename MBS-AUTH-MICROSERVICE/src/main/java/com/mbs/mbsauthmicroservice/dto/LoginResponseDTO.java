package com.mbs.mbsauthmicroservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {

    private String status;
    private String accessToken;
}
