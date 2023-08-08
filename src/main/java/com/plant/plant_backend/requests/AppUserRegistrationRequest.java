package com.plant.plant_backend.requests;

public record AppUserRegistrationRequest(
        String name,
        String lastname,
        String email,
        String password
) {

}
