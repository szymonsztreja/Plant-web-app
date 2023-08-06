package com.plant.plant_backend.services;

import com.plant.plant_backend.data.dtos.AppUserDTOMapper;
import com.plant.plant_backend.data.dao.AppUserDao;
import com.plant.plant_backend.data.dtos.AppUserDto;
import com.plant.plant_backend.data.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService{
    private final AppUserDao appUserDao;
    private final AppUserDTOMapper appUserDTOMapper;

    @Autowired
    public AppUserService(AppUserDao appUserDao, AppUserDTOMapper appUserDTOMapper) {
        this.appUserDao = appUserDao;
        this.appUserDTOMapper = appUserDTOMapper;
    }

    public AppUserDto findById(Long id) {
        return appUserDTOMapper.map(
                appUserDao.findById(id)
                        .orElseThrow()
        );
    }

    public List<AppUserDto> getAllUsers() {
        return appUserDao.getAllUsers()
                .stream()
                .map(appUserDTOMapper::map)
                .collect(Collectors.toList());
    }

    public void save(AppUserDto appUserDto) {
        if ( appUserDao.existsAppUserWithEmail(appUserDto.getEmail())) {
            throw new RuntimeException();
        }

        AppUser newAppUser = appUserDTOMapper.mapToEntity(appUserDto);
        appUserDao.save(newAppUser);
    }

    public void delete(Long id) {
        appUserDao.deleteAppUserById(id);
    }   

//    @Override
//    public void updateAppUserById(Long id, Map<String, Object> fields, AppUser appUser) {
////        Optional<AppUser> existingUser = appUserDao.findById(id);
//
////        appUserDao.save(updatedFieldsUser, id);
////        Field[] updateFields = updatedFieldsUser.getClass().getFields();
////        Field[] existingFields = existingUser.getClass().getFields();
////        for (Field field : updateFields) {
////            field.setAccessible(true);
////            try {
////                Object newValue = field.get(updatedFieldsUser);
////                if (newValue != null) {
////                    Field existingUserField = existingUser
////                            .getClass().getDeclaredField(field.getName());
////                    existingUserField.setAccessible(true);
////                    Object oldValue = existingUserField.get(existingUser);
////
////                    if (!newValue.equals(oldValue)) {
////                        existingUserField.set(existingUser, newValue);
////                    }
////                }
////            } catch (NoSuchFieldException | IllegalAccessException e) {
////                throw new RuntimeException(e);
////            }
////        }
//        fields.forEach( (key, value) -> {
//            Field field = ReflectionUtils.findField( AppUser.class, key);
//            field.setAccessible(true);
//            ReflectionUtils.setField( field, appUser, value);
//        });
//        appUserDao.save(appUser);
//    }

}
