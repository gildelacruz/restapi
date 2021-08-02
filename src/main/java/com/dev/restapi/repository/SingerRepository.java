package com.dev.restapi.repository;

import com.dev.restapi.entity.Singer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository <Singer, Long> {

    @Query("Select s from Singer s where s.id = :id")
    public Singer findSingerByIdWithEverything(Long id);

}
