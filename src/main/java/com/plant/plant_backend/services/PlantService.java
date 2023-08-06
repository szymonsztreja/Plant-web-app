package com.plant.plant_backend.services;

import com.plant.plant_backend.data.dao.AppUserDao;
import com.plant.plant_backend.data.dao.PlantDao;
import com.plant.plant_backend.data.dtos.AppUserDTOMapper;
import com.plant.plant_backend.data.dtos.PlantDTOMapper;
import com.plant.plant_backend.data.dtos.PlantDto;
import com.plant.plant_backend.data.model.AppUser;
import com.plant.plant_backend.data.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService{

    private final PlantDao plantDao;
    private final AppUserDao appUserDao;
    private final PlantDTOMapper plantDTOMapper;

    public PlantService(PlantDao plantDao, AppUserDao appUserDao, PlantDTOMapper plantDTOMapper) {
        this.plantDao = plantDao;
        this.appUserDao = appUserDao;
        this.plantDTOMapper = plantDTOMapper;
    }

    public List<PlantDto> findPlantsByOwnerId(Long id){
        return plantDao.findPlantsByOwnerId(id)
                .stream()
                .map( plant -> plantDTOMapper.map(plant))
                .collect(Collectors.toList());
    }

    public PlantDto findById(Long id) {
        return plantDTOMapper.map(
                plantDao.findById(id)
                        .orElseThrow()
        );
    }

    public List<PlantDto> getAllPlants() {
        return plantDao.getAllPlants()
                .stream()
                .map( plant -> new PlantDto(
                        plant.getName(),
                        plant.getLatinName()))
                .collect(Collectors.toList());
    }

    public void save(Long ownerId ,PlantDto plantDto) {
        if (!appUserDao.existsAppUserWithId(ownerId) && plantDto == null){
            throw new RuntimeException();
        }

        AppUser appUser = appUserDao.findById(ownerId).get();
        plantDto.setOwner(appUser);
        Plant plant = plantDTOMapper.mapToEntity(plantDto);
        plantDao.save(plant);
    }

    public void delete(Long id) {
        if (plantDao.existsPlantWithId(id)) {
            plantDao.delete(id);
        } else {
            throw new RuntimeException("When deleting plant: plant doesnt exists!");
        }

    }


    // TODO: updatePlantById()


}
