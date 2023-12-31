package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.model.Plant;
import org.springframework.stereotype.Component;

@Component
public class PlantDTOMapper implements IMapEntities<PlantDto, Plant>{
    @Override
    public PlantDto map(Plant plant) {
        return new PlantDto(
                plant.getName(),
                plant.getLatinName()
        );
    }

    @Override
    public Plant mapToEntity(PlantDto plantDto) {
        return new Plant(
                plantDto.getName(),
                plantDto.getLatinName()
        );
    }

//    @Override
//    public Plant mapToEntity(PlantDto plantDto) {
//        Plant plant = new Plant();
//        plant.setId(plantDto.getId());
//        plant.setName(plantDto.getName());
//        plant.setLatinName(plantDto.getLatinName());
//        plant.setOwner(plantDto.getOwner());
//        return plant;
//    }
}
