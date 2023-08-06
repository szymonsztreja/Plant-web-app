package com.plant.plant_backend.data_access_services;

import com.plant.plant_backend.data.dao.AppUserDao;
import com.plant.plant_backend.data.model.AppUser;
import com.plant.plant_backend.data.repositories.AppUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public class AppUserJPADataAccessService implements AppUserDao {

    private final AppUserRepository appUserRepository;

    public AppUserJPADataAccessService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public Optional<AppUser> findById(Long id) {
        return appUserRepository.findById(id);
    }

    @Override
    public Optional<AppUser> findAppUserByEmail(String email) {
        return appUserRepository.findAppUserByEmail(email);
    }

    @Override
    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public void save(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public void deleteAppUserById(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public void updateAppUserById(AppUser update) {
        appUserRepository.save(update);
    }

    @Override
    public boolean existsAppUserWithEmail(String email) {
        return appUserRepository.existsAppUserByEmail(email);
    }

    @Override
    public boolean existsAppUserWithId(Long id) {
        return appUserRepository.existsById(id);
    }
}
