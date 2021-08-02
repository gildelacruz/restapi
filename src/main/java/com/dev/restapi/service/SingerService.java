package com.dev.restapi.service;


import com.dev.restapi.domain.ErrorMessage;
import com.dev.restapi.entity.Album;
import com.dev.restapi.entity.Singer;
import com.dev.restapi.exception.CustomException;
import com.dev.restapi.repository.SingerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SingerService {

    private static final Logger log = LoggerFactory.getLogger(SingerService.class);

    @Autowired
    private SingerRepository singerRepository;

    public Singer findById(Long id) {
        Singer singer = singerRepository.findById(id).orElse(null);
        if (singer == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, new ErrorMessage("failed", "Resource not found"));
        }
        return singer;
    }

    public Singer findAlbumByIdWithSinger(Long id) {
        Singer singer = singerRepository.findSingerByIdWithEverything(id);
        if (singer == null) {
            throw new CustomException(HttpStatus.NOT_FOUND,new ErrorMessage("failed","Resource not found"));
        }
        return singer;
    }

}
