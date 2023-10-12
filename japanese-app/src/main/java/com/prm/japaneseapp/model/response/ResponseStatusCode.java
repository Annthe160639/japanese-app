package com.prm.japaneseapp.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResponseStatusCode {
    SUCCESS(HttpStatus.OK, "Thành công");

    private HttpStatus httpCode;

    private String message;


}
