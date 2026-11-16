package com.festivalmanager.organization;

import com.festivalmanager.festival.Festival;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;

@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizationId;
    private String organizationName;
    private ArrayList<Festival> festivals;

    public Organization(Long organizationId, String organizationName) {
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.festivals = new ArrayList<>();
    }

    public Organization(String organizationName) {
        this.organizationName = organizationName;
        this.festivals = new ArrayList<>();
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public ArrayList<Festival> getFestivals() {
        return festivals;
    }

    public void setFestivals(ArrayList<Festival> festivals) {
        this.festivals = festivals;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Organization{");
        sb.append("organizationId=").append(organizationId);
        sb.append(", organizationName='").append(organizationName).append('\'');
        sb.append(", festivals=").append(festivals);
        sb.append('}');
        return sb.toString();
    }
}