package com.plant.plant_backend.data.dao;

import com.plant.plant_backend.data.model.Plant;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlantDao {
    List<Plant> findPlantsByOwnerId(Long id);

    Optional<Plant> findById(Long id);

    List<Plant> getAllPlants();

    void save(Plant plant);

    void updatePlantById(Plant update);

    void delete(Long id);
    boolean existsPlantWithId(Long id);
}
