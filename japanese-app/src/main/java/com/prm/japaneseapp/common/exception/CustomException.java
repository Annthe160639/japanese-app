package com.prm.japaneseapp.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomException{
    private int code;
    private String message;


    public CustomException(Exception exception) {
        this.code = exception.hashCode();
        this.message = exception.getMessage();
    }
}
