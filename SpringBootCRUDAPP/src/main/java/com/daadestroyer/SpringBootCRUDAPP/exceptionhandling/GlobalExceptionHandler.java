package com.daadestroyer.SpringBootCRUDAPP.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        String message = resourceNotFoundException.getMessage();
        APIResponse apiResponse = APIResponse.builder().message(message).status("failed").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistedException.class)
    public ResponseEntity<?> resourceAlreadyExitedException(ResourceAlreadyExistedException resourceAlreadyExistedException) {
        String message = resourceAlreadyExistedException.getMessage();
        APIResponse apiResponse = APIResponse.builder().message(message).status("failed").build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
