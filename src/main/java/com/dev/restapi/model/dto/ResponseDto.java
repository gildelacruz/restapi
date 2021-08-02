package com.dev.restapi.model.dto;


import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ResponseDto<T> extends Dto{
    private ResponseStatus status;
    private T data;
    private List<ErrorDto> errors;

    public ResponseDto(ResponseStatus status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseDto(ResponseStatus status, T data, List<ErrorDto> errors) {
        this.status = status;
        this.data = data;
        this.errors = errors;
    }

    public static <T> ResponseDto<T> forSuccess(T data) {
        return new ResponseDto(ResponseStatus.SUCCESS, data);
    }

    public static <T> ResponseDto<T> forError(ErrorDto... errorDtos) {
        return new ResponseDto(ResponseStatus.ERROR, Arrays.asList(errorDtos));
    }

    public static <T> ResponseDto<T> forPartial(T data, ErrorDto... errorDtos) {
        return new ResponseDto(ResponseStatus.PARTIAL, data, Arrays.asList(errorDtos));
    }

}
