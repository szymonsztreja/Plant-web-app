package com.plant.plant_backend.data.repositories;

import com.plant.plant_backend.data.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
