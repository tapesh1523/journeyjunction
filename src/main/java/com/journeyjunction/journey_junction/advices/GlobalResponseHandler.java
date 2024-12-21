package com.journeyjunction.journey_junction.advices;

import com.journeyjunction.journey_junction.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalResponseHandler {

    // Handle ResourceNotFoundException
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

    // Handle other types of exceptions (e.g., generic Exception)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleGenericException(Exception exception) {
        // Create a generic error message
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message("An unexpected error occurred: " + exception.getMessage())
                .build();

        // Return the error response with the custom ApiResponse wrapper
        return buildErrorResponseEntity(apiError);
    }

    // Helper method to create the error response entity
    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        // Wrap the error in an ApiResponse and return it with the appropriate HTTP status
        ApiResponse<ApiError> apiResponse = new ApiResponse<>(apiError);
        return new ResponseEntity<>(apiResponse, apiError.getStatus());
    }
}
