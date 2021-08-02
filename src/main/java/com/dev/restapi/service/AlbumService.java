package com.dev.restapi.service;

import com.dev.restapi.domain.ErrorMessage;
import com.dev.restapi.entity.Album;
import com.dev.restapi.exception.CustomException;
import com.dev.restapi.repository.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private static final Logger log = LoggerFactory.getLogger(AlbumService.class);

    @Autowired
    private AlbumRepository albumRepository;

    public Album findAlbumByIdWithSinger (Long id) {
        Album album = albumRepository.findAlbumByIdWithSinger(id);
        if (album == null) {
            throw new CustomException(HttpStatus.NOT_FOUND,new ErrorMessage("failed","Resource not found"));
        }
        return album;
    }

    public Album findById (Long id) {
        Album album = albumRepository.findById(id).orElse(null);
        if (album == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, new ErrorMessage("failed", "Resource not found"));
        }
        return album;
    }
}
