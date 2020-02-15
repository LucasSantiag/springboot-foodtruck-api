package dev.lucas.foodtruck.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException() {
        super("Entity not Found");
    }
}
