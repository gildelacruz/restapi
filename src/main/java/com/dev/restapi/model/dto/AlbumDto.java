package com.dev.restapi.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class AlbumDto extends Dto {
    private Long id;
    private String title;
    private Date releaseDate;

    public AlbumDto() {}

}
