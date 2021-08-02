package com.dev.restapi.controller;

import com.dev.restapi.converter.EntityConverter;
import com.dev.restapi.entity.Album;
import com.dev.restapi.entity.Singer;
import com.dev.restapi.model.dto.AlbumDto;
import com.dev.restapi.model.dto.AlbumWithSingerDto;
import com.dev.restapi.model.dto.ResponseDto;
import com.dev.restapi.service.AlbumService;
import com.dev.restapi.service.SingerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/")
public class MusicdbController {

        @Autowired
        private AlbumService albumService;

        @Autowired
        private SingerService singerService;

        @Autowired
        private ModelMapper modelMapper;

        @GetMapping(path="/album/{id}/singer")
        public ResponseEntity<ResponseDto<AlbumWithSingerDto>> findAlbumByIdWithSinger(@PathVariable Long id) {
                Album album = albumService.findAlbumByIdWithSinger(id);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(convertToAlbumWithSingerDto(album)));
        }

        @GetMapping(path="/album/{id}")
        public ResponseEntity<ResponseDto<AlbumDto>> findAlbumById(@PathVariable Long id) {
                Album album = albumService.findById(id);
                return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.forSuccess(convertToAlbumDto(album)));
        }

        @GetMapping(path="/singer/{id}")
        public ResponseEntity findSingerById(@PathVariable Long id) {
                Singer singer = singerService.findById(id);
                return ResponseEntity.status(HttpStatus.OK).body(EntityConverter.convertSingerDomain(singer));

        }

        @GetMapping(path="/singer/{id}/albums")
        public ResponseEntity findSingerByIdWithAlbum(@PathVariable Long id) {
                Singer singer = singerService.findAlbumByIdWithSinger(id);
                return ResponseEntity.status(HttpStatus.OK).body(EntityConverter.convertSingerWithAlbumDomain(singer));

        }

        @GetMapping(path="/singer/{id}/albums/instruments")
        public ResponseEntity findSingerByIdIncludeAll(@PathVariable Long id) {
                Singer singer = singerService.findAlbumByIdWithSinger(id);
                return ResponseEntity.status(HttpStatus.OK).body(EntityConverter.convertSingerWithEveryThing(singer));

        }

        private AlbumDto convertToAlbumDto(Album album) {
                return modelMapper.map(album, AlbumDto.class);
        }

        private AlbumWithSingerDto convertToAlbumWithSingerDto(Album album) {
                return modelMapper.map(album, AlbumWithSingerDto.class);
        }
}
