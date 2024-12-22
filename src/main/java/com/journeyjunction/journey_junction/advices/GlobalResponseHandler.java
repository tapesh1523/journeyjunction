package com.journeyjunction.journey_junction.advices;

import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalResponseHandler {

    // Handle DataIntegrityViolationException (e.g., NOT NULL constraint violation)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<?>> handleDataIntegrityViolation(DataIntegrityViolationException exception) {
        // Extract user-friendly message from the exception
        String userMessage = extractErrorMessage(exception);

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(userMessage)
                .build();

        return buildErrorResponseEntity(apiError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<?>> handleResourceNotFound(ResourceNotFoundException exception) {
        // Create an ApiError for the exception
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();

        // Return the error response with the custom ApiResponse wrapper
        return buildErrorResponseEntity(apiError);
    }

    // Helper method to create the error response entity
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        ApiResponse<ApiError> apiResponse = new ApiResponse<>(apiError);
        return new ResponseEntity<>(apiResponse, apiError.getStatus());
    }

    // Method to parse and extract the user-friendly message from DataIntegrityViolationException
    private String extractErrorMessage(DataIntegrityViolationException exception) {
        // Get the exception message (from the database constraint violation)
        String message = exception.getMessage();

        // Check if the message contains a "null value" violation for a specific column
        if (message.contains("null value in column")) {
            // Extract the column name (e.g., "description") and return a custom message
            String columnName = message.split("\"")[1]; // Extract the column name from the message
            return String.format("The field '%s' cannot be null. Please provide a value.", columnName);
        }

        // If the message doesn't contain a specific pattern, return a generic error
        return "Invalid data input: " + message;
    }



}
