package com.dev.restapi.domain;

import lombok.Data;

@Data
public class ErrorDto {
    private String code;
    private String message;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
