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

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Đăng nhập thất bại"),

    REGISTER_FAILED(HttpStatus.BAD_REQUEST, "Đăng ký thất bại"),

    INTERNAL_SERVER(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi server"),

    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "Validate thất bại"),

    NOT_FOUND(HttpStatus.NOT_FOUND, "Không tìm thấy");

    private HttpStatus httpCode;

    private String message;


}
