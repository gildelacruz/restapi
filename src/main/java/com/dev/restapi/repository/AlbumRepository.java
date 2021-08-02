package com.dev.restapi.repository;

import com.dev.restapi.entity.Album;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AlbumRepository extends CrudRepository<Album,Long> {

    @Query("Select a from Album a where a.id = :id")
    public Album findAlbumByIdWithSinger(Long id);

    @Override
    @Query(value = "Select * from Album where id = :id",nativeQuery = true)
    public Optional<Album> findById(Long id);
}
