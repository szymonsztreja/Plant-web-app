package com.plant.plant_backend.data.model;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private AppUser author;
    @ManyToOne
    @JoinColumn(name = "plantId")
    private Plant plant;
    private String title;
    private String content;

    public Post(AppUser author, Plant plant, String title, String content) {
        this.author = author;
        this.plant = plant;
        this.title = title;
        this.content = content;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
