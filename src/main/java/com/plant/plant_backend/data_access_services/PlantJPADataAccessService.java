package com.plant.plant_backend.data_access_services;

import com.plant.plant_backend.data.dao.PlantDao;
import com.plant.plant_backend.data.model.Plant;
import com.plant.plant_backend.data.repositories.PlantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class PlantJPADataAccessService implements PlantDao {

    private final PlantRepository plantRepository;

    public PlantJPADataAccessService(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public List<Plant> findPlantsByOwnerId(Long id) {
        return plantRepository.findPlantsByOwnerId(id);
    }

    @Override
    public Optional<Plant> findById(Long id) {
        return plantRepository.findById(id);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public void save(Plant plant) {
        plantRepository.save(plant);
    }

    @Override
    public void updatePlantById(Plant update) {
        plantRepository.save(update);
    }

    @Override
    public void delete(Long id) {
        plantRepository.deleteById(id);
    }

    @Override
    public boolean existsPlantWithId(Long id) {
        return plantRepository.existsById(id);
    }
}
