package com.dev.restapi.model.dto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ResponseDtoTests {

    @Test
    public void whenSuccess() {

    }

    @Test
    public void whenSingleError() {
        ErrorDto errorDto = new ErrorDto("100","not found");
        ResponseDto responseDto = ResponseDto.forError(errorDto);
        assertEquals(ResponseStatus.ERROR,responseDto.getStatus());
    }

    @Test
    public void whenListOfErrors(){

    }

    @Test
    public void whenPartialError() {

    }

    @Test
    public void whenPartialErrors() {

    }
}
