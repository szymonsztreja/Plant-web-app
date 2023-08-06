package com.plant.plant_backend.exceptions;

public class UserNotFoundException extends RuntimeException {
    @Override
    public String getMessage(){
        return "User does not exist";
    }
}
