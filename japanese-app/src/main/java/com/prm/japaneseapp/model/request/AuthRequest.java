package com.prm.japaneseapp.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AuthRequest {

    @Email
    private String mail;

    @NotBlank
    private String password;
}
