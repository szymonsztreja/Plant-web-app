package com.plant.plant_backend.data.dtos;

import com.plant.plant_backend.data.dtos.AppUserDto;
import com.plant.plant_backend.data.model.AppUser;
import org.springframework.stereotype.Component;


@Component
public class AppUserDTOMapper  implements IMapEntities<AppUserDto, AppUser>{

    @Override
    public AppUserDto map(AppUser appUser) {
        return new AppUserDto(
                appUser.getName(),
                appUser.getLastname(),
                appUser.getEmail(),
                appUser.getProfileImg()
        );
    }

    @Override
    public AppUser mapToEntity(AppUserDto appUserDto) {
        return null;
    }
//    @Override
//    public AppUser mapToEntity(AppUserDto appUserDto) {
//        AppUser appUser = new AppUser();
//        appUser.setId(appUserDto.getId());
//        appUser.setName(appUserDto.getName());
//        appUser.setLastname(appUserDto.getLastname());
//        appUser.setEmail(appUserDto.getEmail());
//        appUser.setPasswordHash(appUserDto.getPasswordHash());
//        appUser.setRegisteredAt(appUserDto.getRegisteredAt());
//        appUser.setLastLogin(appUserDto.getLastLogin());
//        appUser.setProfileImg(appUserDto.getProfileImg());
//        return appUser;
//    }

}
