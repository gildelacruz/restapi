package com.dev.restapi.entity;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@Entity
public class Album {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "SINGER_ID")
        private Singer singer;

        private String title;
        @Column(name = "RELEASE_DATE")
        private Date releaseDate;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Singer getSinger() {
                return singer;
        }

        public void setSinger(Singer singer) {
                this.singer = singer;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public Date getReleaseDate() {
                return releaseDate;
        }

        public void setReleaseDate(Date releaseDate) {
                this.releaseDate = releaseDate;
        }

        @Override
        public String toString(){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return String.format("Album - id: %d, Singer id: %d, Title: %s, Release Date: %s",
                        id, singer.getId(), title, sdf.format(releaseDate));
        }
}
