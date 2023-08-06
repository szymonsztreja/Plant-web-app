package com.plant.plant_backend.data.repositories;

import com.plant.plant_backend.data.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByEmail(String email);
    boolean existsAppUserByEmail(String email);
//    void save(AppUser updatedFieldsUser, Long id);
}
