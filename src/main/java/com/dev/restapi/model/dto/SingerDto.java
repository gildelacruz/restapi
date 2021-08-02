package com.dev.restapi.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SingerDto extends Dto{

    //private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public SingerDto(){}

    //public SingerDto(Long id, String firstName, String lastName, Date birthDate){
    public SingerDto(String firstName, String lastName, Date birthDate){

        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

}
