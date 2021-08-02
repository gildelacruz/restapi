package com.dev.restapi.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AlbumWithSingerDto extends Dto{

    private Long id;
    private SingerDto singer;
    private String title;
    private Date releaseDate;

    public AlbumWithSingerDto() {}

}
