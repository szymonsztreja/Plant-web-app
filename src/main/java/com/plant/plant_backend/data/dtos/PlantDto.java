package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.AppUser;

public class PlantDto {

    private long id;
    private String name;
    private String latinName;
    private AppUser owner;

    public PlantDto(long id, String name, String latinName, AppUser owner) {
        this.id = id;
        this.name = name;
        this.latinName = latinName;
        this.owner = owner;
    }

    public PlantDto(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatinName() {
        return latinName;
    }

    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }

    public AppUser getOwner() {
        return owner;
    }

    public void setOwner(AppUser owner) {
        this.owner = owner;
    }
}
