package com.prm.japaneseapp.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private String token;

    private Long id;

    private String mail;

    private String lastName;

    private String firstName;

    private String phone;

    private Date dob;

    private String avatar;
}
