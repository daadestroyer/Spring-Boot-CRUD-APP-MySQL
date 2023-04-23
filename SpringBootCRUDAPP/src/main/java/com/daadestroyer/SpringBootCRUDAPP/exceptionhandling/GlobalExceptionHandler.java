package com.daadestroyer.SpringBootCRUDAPP.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

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

    // this handler help us take all the validation error and put it in the map to send in response
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> resp = new HashMap<>();
        ex.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
