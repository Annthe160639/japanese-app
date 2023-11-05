package com.prm.japaneseapp.dto.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AccountRequestDto {

    @NotBlank(message = "{account.name.required}")
    @Email
    private String mail;

    @NotBlank(message = "{account.password.required}")
    private String password;

    @NotBlank(message = "{account.lastname.required}")
    private String lastName;

    @NotBlank(message = "{account.firstName.required}")
    private String firstName;

}
