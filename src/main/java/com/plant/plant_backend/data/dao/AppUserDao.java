package com.plant.plant_backend.data.dao;

import com.plant.plant_backend.data.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    Optional<AppUser> findById(Long id);
    Optional<AppUser> findAppUserByEmail(String email);
    List<AppUser> getAllUsers();
    void save(AppUser appUser);
    void deleteAppUserById(Long id);
    void updateAppUserById(AppUser appUser);
    boolean existsAppUserWithEmail(String email);
    boolean existsAppUserWithId(Long id);
}
