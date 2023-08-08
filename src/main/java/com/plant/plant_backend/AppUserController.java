package com.plant.plant_backend;

import com.plant.plant_backend.data.dtos.AppUserDto;
import com.plant.plant_backend.requests.AppUserRegistrationRequest;
import com.plant.plant_backend.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getAppUserById(@PathVariable Long id){
        return new ResponseEntity<>(appUserService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveAppUser(@RequestBody AppUserRegistrationRequest registrationRequest){
        appUserService.save(registrationRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/")
    public void saveAppUser(@RequestParam Long id){
        appUserService.delete(id);
    }

//    @PatchMapping("/{id}")
//    public  ResponseEntity<AppUser> updateAppUser(
//            @PathVariable Long id,
//            @RequestBody Map<String, Object> fields){
//        appUserService.update
//    }

}
