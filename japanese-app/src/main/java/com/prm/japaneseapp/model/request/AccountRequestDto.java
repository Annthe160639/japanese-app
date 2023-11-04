package com.prm.japaneseapp.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AccountRequestDto {

    @NotBlank(message = "{account.name.required}")
    @Email
    private String mail;

    @NotBlank(message = "{account.password.required}")
    private String password;

    @NotBlank(message = "{account.password.required}")
    private String lastName;

    @NotBlank(message = "{account.password.required}")
    private String firstName;

    @NotBlank(message = "{account.password.required}")
    private String phone;

    @NotNull
    private Date dob;

    private String avatar;
}
