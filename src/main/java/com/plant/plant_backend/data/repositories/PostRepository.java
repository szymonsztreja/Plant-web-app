package com.plant.plant_backend.data.repositories;

import com.plant.plant_backend.data.model.Plant;
import com.plant.plant_backend.data.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByPlantId(Long id);
}
