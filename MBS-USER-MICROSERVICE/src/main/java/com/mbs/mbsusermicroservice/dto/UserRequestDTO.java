package com.mbs.mbsusermicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$", message = "must contain letters only")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$", message = "must contain letters only")
    private String lastName;

    @NotBlank
    @Email(message = "must be a valid email")
    private String email;

    @NotBlank
    private String phone;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%_*?&])[A-Za-z\\d@$!%_*?&]+$",
            message = "must contain uppercase, lowercase, number, and special character")
    private String password;
}
