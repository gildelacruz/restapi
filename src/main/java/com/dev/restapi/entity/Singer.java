package com.dev.restapi.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Singer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name ="FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @OneToMany(mappedBy = "singer")
    private List<Album> albums;

    @ManyToMany
    @JoinTable(
            name="SINGER_INSTRUMENT",
            joinColumns = @JoinColumn(name="SINGER_ID"),
            inverseJoinColumns = @JoinColumn(name="INSTRUMENT_ID")
    )
    private List<Instrument> instruments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return String.format("Singer-> Id: %d, First Name: %s, Last Name: %s, Birth Date: %t, Number of Album: %d ", id, firstName, lastName, birthDate, albums.size());
    }
}
