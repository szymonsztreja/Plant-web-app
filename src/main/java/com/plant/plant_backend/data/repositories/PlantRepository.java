package com.plant.plant_backend.data.repositories;

import com.plant.plant_backend.data.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {

    List<Plant> findPlantsByOwnerId(Long ownerId);
}
