package com.example.music.model.entities;

import com.example.music.model.entities.enums.BandNames;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "artists")
public class Artist extends BaseEntity{
    private BandNames bandNames;
    private String information;

    public Artist() {
    }

    @Enumerated(EnumType.STRING)
    public BandNames getBandNames() {
        return bandNames;
    }

    public void setBandNames(BandNames bandNames) {
        this.bandNames = bandNames;
    }

    @Column(nullable = false, columnDefinition = "Text")
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
