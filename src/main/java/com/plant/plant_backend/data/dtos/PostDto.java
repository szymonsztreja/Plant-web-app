package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.AppUser;
import com.plant.plant_backend.data.model.Plant;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PostDto {

    private AppUser author;
    private Plant plant;
    private String title;
    private String content;

    public PostDto(AppUser author, Plant plant, String title, String content) {
        this.author = author;
        this.plant = plant;
        this.title = title;
        this.content = content;
    }


    public AppUser getAuthor() {
        return author;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
