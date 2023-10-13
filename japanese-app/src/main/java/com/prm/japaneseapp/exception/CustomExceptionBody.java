package com.prm.japaneseapp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomExceptionBody {
    private int code;
    private String message;


    public CustomExceptionBody(Exception exception) {
        this.code = exception.hashCode();
        this.message = exception.getMessage();
    }
}
