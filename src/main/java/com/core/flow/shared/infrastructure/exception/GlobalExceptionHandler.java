package com.core.flow.shared.infrastructure.exception;

import com.core.flow.shared.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUserInputException.class)
    public ResponseEntity<ApiResponse<Object>> handleInvalidUserInput(InvalidUserInputException ex) {
        ApiResponse<Object> errorResponse = new ApiResponse<>("ERROR", ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    // Optional: Add generic error handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(Exception ex) {
        ApiResponse<Object> errorResponse = new ApiResponse<>("ERROR", "An unexpected error occurred.", null);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
