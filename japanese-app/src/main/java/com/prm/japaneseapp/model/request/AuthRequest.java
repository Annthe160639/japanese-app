package com.prm.japaneseapp.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String mail;
    private String password;
}
