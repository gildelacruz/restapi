package com.dev.restapi.converter;

import com.dev.restapi.model.dto.AlbumWithSingerDto;
import com.dev.restapi.model.dto.SingerDto;
import com.dev.restapi.model.dto.SingerWithAlbum;
import com.dev.restapi.model.dto.SingerWithAll;
import com.dev.restapi.entity.Instrument;
import com.dev.restapi.entity.Singer;
import com.dev.restapi.entity.Album;

import java.util.ArrayList;
import java.util.List;

public final class EntityConverter {

    private EntityConverter() {}

    public static SingerDto convertSingerDomain(Singer singer) {
        SingerDto retSinger = new SingerDto();
        //retSinger.setId(singer.getId());
        retSinger.setFirstName(singer.getFirstName());
        retSinger.setLastName(singer.getLastName());
        retSinger.setBirthDate(singer.getBirthDate());
        return retSinger;
    }

    public static SingerWithAlbum convertSingerWithAlbumDomain(Singer singer) {
        SingerWithAlbum retSingerWithAlbum = new SingerWithAlbum();
        retSingerWithAlbum.setId(singer.getId());
        retSingerWithAlbum.setFirstName(singer.getFirstName());
        retSingerWithAlbum.setLastName(singer.getLastName());
        retSingerWithAlbum.setBirthDate(singer.getBirthDate());
        List<Album> albums = singer.getAlbums();
        List<com.dev.restapi.model.dto.AlbumDto> albumDomains = new ArrayList<>();
        for (Album album : albums) {
            com.dev.restapi.model.dto.AlbumDto albumDomain = new com.dev.restapi.model.dto.AlbumDto();
            albumDomain.setId(album.getId());
            albumDomain.setTitle(album.getTitle());
            albumDomain.setReleaseDate(album.getReleaseDate());
            albumDomains.add(albumDomain);
        }
        retSingerWithAlbum.setAlbums(albumDomains);
        return retSingerWithAlbum;
    }

    public static SingerWithAll convertSingerWithEveryThing(Singer singer) {
        SingerWithAll retSingerWithAll = new SingerWithAll();
        retSingerWithAll.setId(singer.getId());
        retSingerWithAll.setFirstName(singer.getFirstName());
        retSingerWithAll.setLastName(singer.getLastName());
        retSingerWithAll.setBirthDate(singer.getBirthDate());
        List<Album> albums = singer.getAlbums();
        List<com.dev.restapi.model.dto.AlbumDto> albumDomains = new ArrayList<>();
        for (Album album : albums) {
            com.dev.restapi.model.dto.AlbumDto albumDomain = new com.dev.restapi.model.dto.AlbumDto();
            albumDomain.setId(album.getId());
            albumDomain.setTitle(album.getTitle());
            albumDomain.setReleaseDate(album.getReleaseDate());
            albumDomains.add(albumDomain);
        }
        retSingerWithAll.setAlbums(albumDomains);

        List<Instrument> instruments = singer.getInstruments();
        List<com.dev.restapi.model.dto.Instrument> instrumentsDomains = new ArrayList<>();
        for (Instrument instrument : instruments) {
            com.dev.restapi.model.dto.Instrument instrumentDomain = new com.dev.restapi.model.dto.Instrument();
            instrumentDomain.setInstrumentId(instrument.getInstrumentId());
            instrumentsDomains.add(instrumentDomain);
        }
        retSingerWithAll.setInstruments(instrumentsDomains);
        return retSingerWithAll;
    }
}
