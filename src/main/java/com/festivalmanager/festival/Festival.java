package com.festivalmanager.festival;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long festivalId;
    private String festivalName;
    private int festivalYear;
    private String festivalLocation;

    public Festival() {

    }
    public Festival(Long festivalId, String festivalName, int festivalYear, String festivalLocation) {
        this.festivalId = festivalId;
        this.festivalName = festivalName;
        this.festivalYear = festivalYear;
        this.festivalLocation = festivalLocation;
    }
    public Festival(String festivalName, int festivalYear, String festivalLocation) {
        this.festivalName = festivalName;
        this.festivalYear = festivalYear;
        this.festivalLocation = festivalLocation;
    }
    public Long getFestivalId() {
        return festivalId;
    }
    public void setFestivalId(Long festivalId) {
        this.festivalId = festivalId;
    }
    public String getFestivalName() {
        return festivalName;
    }
    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName;
    }
    public int getFestivalYear() {
        return festivalYear;
    }
    public void setFestivalYear(int festivalYear) {
        this.festivalYear = festivalYear;
    }
    public String getFestivalLocation() {
        return festivalLocation;
    }
    public void setFestivalLocation(String festivalLocation) {
        this.festivalLocation = festivalLocation;
    }
    @Override
    public String toString() {
        return "Festival [festivalId=" + festivalId + ", festivalName=" + festivalName + ", festivalYear=" + festivalYear
                + ", festivalLocation=" + festivalLocation + "]";
    }



}
