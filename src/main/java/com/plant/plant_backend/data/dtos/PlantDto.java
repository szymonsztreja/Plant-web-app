package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.AppUser;

public class PlantDto {

    private String name;
    private String latinName;

    public PlantDto(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
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
}
