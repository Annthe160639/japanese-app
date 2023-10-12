package com.prm.japaneseapp.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountRequestDto {

    @NotBlank(message = "{account.name.required}")
    private String mail;

    private String password;
}
