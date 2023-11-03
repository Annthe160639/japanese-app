package com.prm.japaneseapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseStatusCode {
    SUCCESS(HttpStatus.OK, "Thành công"),

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Đăng nhập thất bại")

    ;

    private HttpStatus httpCode;

    private String message;


}
