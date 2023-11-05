package com.prm.japaneseapp.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthRequestDto {

    @Email
    private String mail;

    @NotBlank
    private String password;
}
