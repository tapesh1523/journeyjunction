package com.journeyjunction.journey_junction.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {}

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
