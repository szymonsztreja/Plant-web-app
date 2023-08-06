package com.plant.plant_backend;

import com.plant.plant_backend.data.dtos.PlantDto;
import com.plant.plant_backend.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/plant")
public class PlantController {

    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlantDto> getPlantById(@PathVariable Long id){
        PlantDto plantDto = plantService.findById(id);
        return new ResponseEntity<>(plantDto, HttpStatus.OK);
    }

    @GetMapping("/ownerId/{id}")
    public ResponseEntity<List<PlantDto>> getPlantByOwnerId(@PathVariable Long id){
        return new ResponseEntity<>(plantService.findPlantsByOwnerId(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlantDto>> getAllPlants(){
        return new ResponseEntity<>(plantService.getAllPlants(), HttpStatus.OK);
    }

    @PostMapping("/ownerId/{id}")
    public ResponseEntity<PlantDto> savePlant(@RequestBody PlantDto plantDto, @PathVariable Long id){
        plantService.save(id, plantDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/")
    public ResponseEntity<PlantDto> deletePlant(@RequestParam Long id){
        plantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public  ResponseEntity<Plant> updatePlant(@PathVariable Long id,
//                                                  @RequestBody Map<String, Object> fields){
//        Optional<Plant> plant = plantService.findById(id);
//        if( !plant.isPresent() ){
//            throw new UserNotFoundException();
//        }
//        plantService.updatePlantById(id, fields, plant.get());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
