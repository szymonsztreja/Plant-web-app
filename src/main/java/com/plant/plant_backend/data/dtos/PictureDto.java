package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.Plant;
import com.plant.plant_backend.data.model.Post;

public class PictureDto {

    private long id;
    private Plant plant;
    private Post post;
    private String imageUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
